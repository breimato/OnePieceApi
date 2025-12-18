# One Piece API

A comprehensive REST API built with **Java 21** and **Spring Boot 3**, providing detailed information about the One Piece universe, including characters, devil fruits, affiliations, and more.

## 🚀 Tehnologies

- **Java 21**: Leveraging the latest language features.
- **Spring Boot 3.x**: Core framework for building the web application.
- **Hexagonal Architecture**: Separation of concerns between domain logic and infraestructure.
- **MyBatis**: SQL-centric persistence layer for maximum control.
- **PostgreSQL**: Robust relational database.
- **Flyway**: Database versioning and migrations.
- **OpenAPI (Swagger)**: API documentation and contract-first development.
- **MapStruct**: Efficient and type-safe bean mapping.
- **Lombok**: Reduced boilerplate code.
- **JUnit 5 & Mockito**: Unit testing.
- **Instancio**: Data generation for robust testing.

## 🏗 Architecture

The project follows a **Hexagonal Architecture** (also known as Ports and Adapters):

- **Core**: Contains the domain entities, value objects, and business logic (Use Cases).
- **Ports**: Interfaces defining how the core communicates with the outside world (Incoming and Outgoing).
- **Adapters**:
    - **Inbound (REST)**: Controllers and DTOs mapping external requests to the core.
    - **Outbound (Persistence)**: Repositories and MyBatis mappers implementation.

## 🛠 Setup & Installation

### Prerequisites

- **JDK 21**
- **Maven 3.8+**
- **PostgreSQL**

### Database Configuration

Create a database named `onepiece_db` and configure the connection in `web/src/main/resources/application.properties` (or use environment variables):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/onepiece_db
spring.datasource.username=your_user
spring.datasource.password=your_password
```

### Running the Application

1. Clone the repository.
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run -pl web
   ```

## 📖 API Documentation

Once the application is running, you can access the Swagger UI to explore the API:

```
http://localhost:8080/swagger-ui.html
```

## 🧪 Testing

The project emphasizes clean and robust testing following the **Given-When-Then** structure.

Run all tests:
```bash
mvn test
```

## 📝 Project Rules (for contributors)

- Use **Java 21** features (var, records, etc.).
- Follow **Clean Code** and **SOLID** principles.
- Use **Lombok** and **MapStruct** where appropriate.
- Every new feature should include unit tests using **Instancio** for object generation.
- Keep the domain pure and free of infrastructure dependencies.

---
*Created with ❤️ by the One Piece API Team (Me xd).*
