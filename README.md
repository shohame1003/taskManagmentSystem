# [Swagger url](http://localhost:8888/api/v1/swagger-ui/index.html) 
# Task Management System (TaskManagmentSystem)

**TaskManagmentSystem** is a backend application built using Spring Boot and Hibernate. Its primary purpose is to handle basic CRUD (Create, Read, Update, Delete) operations related to task management.

## Table of Contents

- [Technology Stack](#technology-stack)
- [Endpoints and Operations](#endpoints-and-operations)
- [Configuration Details](#configuration-details)
- [Author](#author)

## Technology Stack

- **Spring Boot**: A powerful Java framework for building production-ready applications.
- **Hibernate**: An ORM (Object-Relational Mapping) library that simplifies database interactions.
- **MySQL**: The chosen database system.

## Endpoints and Operations

### Create (POST)

To add a new task, make a POST request to:

- Endpoint: [http://localhost:8080/create](http://localhost:8080/create)
- Parameters (in JSON format):
  - `title` (String, required): Name of the task
  - `description` (String, required): Task details
  - `deadline` (Date, required): Due date

### Read (GET)

Retrieve task details using:

- Endpoint: [http://localhost:8080/read](http://localhost:8080/read)
- Get task details by ID:
  - [http://localhost:8080/read/no/{id}](http://localhost:8080/read/no/{id}) (replace `{id}` with the task ID)

### Update (PUT)

Modify task information:

- Endpoint: [http://localhost:8080/update/{id}](http://localhost:8080/update/{id}) (replace `{id}` with the task ID)
- Parameters (in JSON format):
  - `title` (String): Updated task title
  - `description` (String): Updated task details
  - `deadline` (Date): Updated due date

### Delete

Remove a task:

- Delete all tasks: [http://localhost:8083/delete/all](http://localhost:8080/delete/all)
- Delete a specific task: [http://localhost:8083/delete/no/{id}](http://localhost:8080/delete/no/{id}) (replace `{id}`)

## Configuration Details

Unfortunately, specific configuration details (such as database connection settings, Spring Boot configuration files, etc.) are not provided in this README. However, in a typical Spring Boot project, you'll find:

- **`application.properties` or `application.yml`**:
  - Database connection settings (URL, username, password).
  - Other application-specific properties.

- **Entity Classes**:
  - These define the data model (e.g., a "Task" object).
  - Annotations such as `@Entity`, `@Table`, and `@Column` map Java classes to database tables and columns.

- **Repository Interfaces**:
  - These extend `JpaRepository` or similar interfaces.
  - They provide methods for CRUD operations (Spring Data JPA magic!).

## Author

- [shohame1003](https://github.com/shohame1003)

🚀👨‍💻
