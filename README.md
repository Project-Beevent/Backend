# Kanver - Backend

The backend is built with Spring Boot. It connects to a PostgreSQL database. Follow the steps below to set up and run the backend server.

## Prerequisites

Ensure you have the following prerequisites installed on your system:

- [Docker](https://www.docker.com/get-started)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- Integrated Development Environment (IDE) for Spring, such as [IntelliJ](https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=EMEA_en_TR_IDEA_Branded&term=intellij&content=619479151433&gclid=CjwKCAiApuCrBhAuEiwA8VJ6JlQbcnH8jIklp-ZEi2X74TRKNA-Jz5cWjWwumwTgZQaHw7auozMrEhoCINEQAvD_BwE&section=windows).

## How to run the Kanver backend server

- Run the following command to start the PostgreSQL container:

   ```bash
   docker-compose up -d

- Build the project and run it. The application will be accessible at http://localhost:8080
