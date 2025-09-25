# Employee Management System - Standalone Web Application

A standalone Java web application for managing employee records, built with embedded Jetty server and packaged as an executable JAR.

## Features

- Employee CRUD operations (Create, Read, Update, Delete)
- Employee search by name or ID
- Bootstrap-based responsive UI
- JSP-based view templates
- In-memory employee storage

## Technology Stack

- **Java 17** - Programming language
- **Servlet API 3.1** - Web framework
- **JSP & JSTL** - View templates
- **Embedded Jetty 9.4** - Web server
- **Bootstrap** - UI framework
- **Maven** - Build tool

## Build Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Building the Application

To build the executable JAR file:

```bash
mvn clean package
```

This will create `target/emp-demo-standalone.jar` - a fully self-contained executable JAR.

## Running the Application

### Default Port (8080)
```bash
java -jar target/emp-demo-standalone.jar
```

### Custom Port
```bash
java -jar target/emp-demo-standalone.jar 9090
```

### Access the Application

Once started, open your browser and navigate to:
- http://localhost:8080 (or your custom port)

The application will display the employee management interface with:
- List of existing employees
- Search functionality
- Add new employee form
- Edit/Delete operations

## Application Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/mahendra/employees/
│   │       ├── Application.java      # Main class with embedded Jetty
│   │       ├── Employee.java         # Employee entity
│   │       ├── EmployeeList.java     # In-memory data store
│   │       ├── EmployeeService.java  # Business logic
│   │       └── EmployeeServlet.java  # Web controller
│   └── resources/
│       └── webapp/                   # Web resources (JSP, CSS, JS)
```

## Development

### Running in Development Mode
You can run the application directly from Maven:

```bash
mvn compile exec:java -Dexec.mainClass="com.mahendra.employees.Application"
```

### Rebuilding
After making code changes:

```bash
mvn clean package
java -jar target/emp-demo-standalone.jar
```

## Deployment

The application is completely self-contained. To deploy:

1. Copy the `emp-demo-standalone.jar` file to your target environment
2. Ensure Java 17+ is installed
3. Run: `java -jar emp-demo-standalone.jar [port]`

No external servlet container (like Tomcat) is required.

## Default Employee Data

The application comes pre-loaded with sample employee data including:
- John Smith (Manager, Sales)
- Laura Adams (Manager, IT)
- Peter Williams (Coordinator, HR)
- Joana Sanders (Manager, Marketing)
- John Drake (Coordinator, Finance)
- Samuel Williams (Coordinator, Finance)

## Configuration

- **Server Port**: Configurable via command line argument
- **Context Path**: Root ("/")
- **Session Timeout**: Default Jetty settings
- **Employee Data**: In-memory storage (resets on restart)