# HTTP Users Application

This is a Java-based application that uses Spring Boot and Gradle. The application is designed to interact with a RESTful API to fetch user data from JSONPlaceholder.

## Features

- Fetch all users
- Fetch a specific user by ID

## Technologies Used

- Java
- Spring Boot
- Gradle
- RESTful API (JSONPlaceholder)

## Project Structure

The project is structured into several packages and classes:

- `ro.abarcan.httpusers`: Contains the main application class `HttpUsersApplication.java` which is the entry point of the Spring Boot application.
- `ro.abarcan.httpusers.user.model`: Contains the `User.java` class which is a record that represents a user.
- `ro.abarcan.httpusers.user.client`: Contains the `UserHttpClient.java` interface which defines the methods to interact with the RESTful API and `UserRestClientTest.java` which contains the tests for the client.
- `ro.abarcan.httpusers.user.config`: Contains the `ClientConfig.java` class which provides the configuration for the REST client and `TestConfig.java` which provides the configuration for the tests.

## HTTP Interfaces and REST Client

The application uses a REST client to make HTTP requests to the JSONPlaceholder API. The base URL for the API is `https://jsonplaceholder.typicode.com`. The `UserHttpClient.java` interface defines the HTTP methods that are used to interact with the API. The `ClientConfig.java` class configures the REST client.

## Setup and Running

To run this application, you need to have Java and Gradle installed on your machine.

1. Clone the repository
2. Navigate to the project directory
3. Run `gradle bootRun` to start the application

## Testing

The project contains unit tests that can be run using the following command:

`gradle test`

## API Reference

The application interacts with the following endpoints:

- `GET /users`: Fetches all users
- `GET /users/{id}`: Fetches a specific user by IDrs/{id}: Fetches a specific user by ID