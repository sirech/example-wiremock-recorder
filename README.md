# Example WireMock Recorder

This is a proof of concept to show how [WireMock](http://wiremock.org/) can be used to manage connections to a third party server in a way that maximizes the conformity to its API while reducing the dependency of the code to it for tasks such as testing and local development.

For an in detail explanation of the whole setup, see this post: https://hceris.com/recording-apis-with-wiremock/

## Requirements to run this app

- Java 8
- A working internet connection :satellite:

## Goals

- Confirm that the connection to the Third Party Server works through an automated test
- Have unit tests that do not rely on external resources, but that use mock data using an external source
- Have a way to easily refresh the test data in an automated way, to confirm that the mock data is compatible with the source
- Use the same mocks for local development without any extra configuration or dependencies needed

## Setup

This is a diagram how it all ties together

![Diagram](./images/diagram.png)

## App

The app exposes two routes

```
/todos
/todos/:id
```

They go against a [real API](https://jsonplaceholder.typicode.com) 

There is a [comprehensive script](./go) to run everything in the app. When run without arguments, it displays all the possible targets.
