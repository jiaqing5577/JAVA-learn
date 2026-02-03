# JAVA-learn

## Project Overview

This is a **Java learning repository** containing basic Java programming exercises and examples.

### Project Structure

- **`_01base`**: Java fundamentals
  - Variables and data types
  - Control flow (if/else, loops)
  - Arrays and methods
  - Basic input/output

- **`_02object`**: Object-Oriented Programming
  - Classes and objects
  - Constructors
  - Encapsulation (private fields, getters/setters)
  - Static methods

## Current State

⚠️ **Important:** This is a learning project with plain Java code examples. It does **NOT** include:
- Web services or REST APIs
- HTTP routes or endpoints
- Web server configuration
- Docker or containerization setup

## Containerized Deployment Routes and Parameters

### Current Answer: 
**This project has no routes or parameters for containerized deployment** because it is not a web application.

### To Make It Containerizable:

If you want to containerize this project, you would need to:

#### 1. Add a Web Framework
Convert the project to a web application using:
- **Spring Boot** (recommended)
- Servlet container (e.g., Tomcat)
- Other Java web frameworks

#### 2. Define API Routes
Example Spring Boot controller:
```java
@RestController
@RequestMapping("/api")
public class ExampleController {
    
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        return "Hello, " + (name != null ? name : "World");
    }
    
    @PostMapping("/data")
    public ResponseEntity<?> createData(@RequestBody DataRequest request) {
        return ResponseEntity.ok("Data received");
    }
}
```

#### 3. Create Dockerfile
```dockerfile
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

#### 4. Example Routes Table

| Method | Route | Parameters | Description |
|--------|-------|------------|-------------|
| GET | `/api/health` | None | Health check |
| GET | `/api/hello` | `{name: string (query, optional)}` | Greeting endpoint |
| POST | `/api/calculate` | `{number1: int, number2: int, operation: string}` | Calculator |
| GET | `/api/person/{id}` | `{id: int (path)}` | Get person info |
| POST | `/api/person` | `{name: string, age: int}` | Create person |

## Documentation

For detailed containerization guide in Chinese, see: [容器化部署说明.md](容器化部署说明.md)

## Getting Started

This is a learning project. Each Java file can be compiled and run independently:

```bash
javac learn/src/_01base/date1.java
java learn.src._01base.date1
```

## Recommendations

1. **For Java basics learning**: Keep the current structure
2. **For web development learning**: Consider refactoring to Spring Boot
3. **For containerization learning**: Follow the guide in the documentation to add web services first

## License

Educational project for learning purposes.
