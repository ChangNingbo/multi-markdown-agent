package me.yufan.multi.markdown;

import lombok.experimental.UtilityClass;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * The entry point for loading, modify the code on the fly.
 *
 * @author せいうはん
 * @version 1.0.0, 2020-01-04 19:48
 * @since 1.0.0, 2020-01-04 19:48
 */
@UtilityClass
public class Agent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("This is an markdown navigation agent.");

        new AgentBuilder.Default()
            .type(named("com.vladsch.idea.multimarkdown.license.LicenseAgent"))
            .transform(
                (builder, typeDescription, classLoader, module) -> builder
                    .method(named("isRemoveLicense")).intercept(value(false))
                    .method(named("getLicenseExpires")).intercept(value("Never Expired"))
                    .method(named("licenseCode")).intercept(value("Hacked by Yufan"))
                    .method(named("isValidLicense")).intercept(value(true))
                    .method(named("isValidActivation")).intercept(value(true))
                    .method(named("getLicenseCode")).intercept(value(true))
                    .method(named("getLicenseType")).intercept(value("license"))
                    .method(named("getLicenseFeatures")).intercept(value(4))
                    .method(named("getLicenseExpiration")).intercept(value("9999-12-31"))
                    .method(named("getActivatedOn")).intercept(value("2018-01-01"))
                    .method(named("getLicenseExpiringIn")).intercept(value(Integer.MAX_VALUE))
                    .method(named("isActivationExpired")).intercept(value(true))
            )
            .installOn(instrumentation);
    }
}
