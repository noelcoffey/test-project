# Portfolio Management Application
The purpose of this application is to provide a set of APIs to manage fund portfolios. 
The following operations are supported 
1. Register Portfolios and Instruments/Securities
2. Add holdings to a Portfolio for a security. The API will calculate the price using a 3rd party API
3. List holdings for a Portfolio for a give day.

## Building the application
To build the app run `mvn clean install` from the command line. 
This will also run unit tests and integration tests for the application

## Running the application
To run the application run `mvn spring-boot:run` from the command line
Once the application has complete the operational documentation for the API can be viewed 
using [Swagger](http://localhost:8080/test-app/swagger-ui/)