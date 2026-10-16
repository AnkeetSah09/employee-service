# Employee Service with Apache Kafka

A Spring Boot application that exposes a REST API to create employees and publishes employee-created events to Apache Kafka.

## Technologies
- Java
- Spring Boot
- Apache Kafka
- Docker
- Maven
- Postman

## Features
- Create employees using `POST /api/employees`
- Validate employee request data
- Handle validation errors globally
- Publish employee data as JSON messages to the `employee-created` Kafka topic

## Run the Project
1. Start Kafka using Docker Compose.
2. Run the Spring Boot application.
3. Send a POST request to `http://localhost:8080/api/employees`.

## Example Request
```json
{
  "name": "Rahul",
  "email": "rahul@example.com",
  "department": "IT"
}
```

## Kafka Topic
`employee-created`

