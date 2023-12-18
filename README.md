# Kanver - Backend

The project built with Spring Boot. It connects to a PostgreSQL database. 

## Prerequisites

Ensure you have the following prerequisites installed on your system:

- [Docker](https://www.docker.com/get-started) - For running a PostgreSQL container.
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- Integrated Development Environment (IDE) for Spring, such as [IntelliJ](https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=EMEA_en_TR_IDEA_Branded&term=intellij&content=619479151433&gclid=CjwKCAiApuCrBhAuEiwA8VJ6JlQbcnH8jIklp-ZEi2X74TRKNA-Jz5cWjWwumwTgZQaHw7auozMrEhoCINEQAvD_BwE&section=windows).

## Running the Application

### 1. Start PostgreSQL Docker Container

- Run the following command to start a PostgreSQL Docker container:

```
docker run --name postgres-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=kanver -p 5432:5432 -d postgres
```

### 2. Build and run the application 

### 3. Access the Application
Open your web browser and navigate to http://localhost:8080 to access the Kanver application.

## Postman Collection

To test the APIs using Postman, import the provided Postman Collection into your Postman workspace. The collection includes sample requests for creating, retrieving, updating, and deleting users.