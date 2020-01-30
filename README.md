# Multi Markdown Agent

A java agent which could be used on IntelliJ IDEA, making the Markdown Navigator be free.

## Requirement

* Java 1.8
* IntelliJ IDEA above 2018.x

## How to build your agent

We don't distribute the binary release for enhancing the requirements of user. You can
clone this project. Simply using `mvn clean package` for building your agent.

## How to use the agent

Edit the `idea.vmoptions` by <kbd>Configure</kbd> or <kbd>Help</kbd> -> <kbd>Edit Custom VM Options ...</kbd> in IDEA.

Append the below line to the file in editor panel.

`-javaagent:/absolute/path/to/multi-markdown-agent.jar`
