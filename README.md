# SMS Splitter Service

A Spring Boot application that splits long SMS messages into multiple parts while maintaining a maximum length of 160 characters per message.

## Features

- Splits long messages into multiple parts
- Adds part numbering (e.g., "... - Part 1 of 3")
- Ensures each part is within the 160-character limit
- RESTful API endpoint
- Input validation
- Error handling
- Unit tests

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Setup and Running

1. Clone the repository
2. Navigate to the project directory
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on port 8080.

## API Usage

### Split Message

**Endpoint:** `POST /api/v1/sms/split`

**Request Body:**
```json
{
    "message": "Your long message here..."
}
```

**Response:**
```json
[
    "First part of the message... - Part 1 of 3",
    "Second part of the message... - Part 2 of 3",
    "Third part of the message... - Part 3 of 3"
]
```

## Architecture Decisions

1. **Project Structure**
   - Used standard Spring Boot project structure
   - Separated concerns into controller, service, and model layers
   - Implemented global exception handling

2. **API Design**
   - RESTful endpoint with versioning (/api/v1)
   - JSON request/response format
   - Proper HTTP status codes
   - Input validation using Jakarta Validation

3. **Error Handling**
   - Global exception handler for consistent error responses
   - Validation errors return 400 Bad Request
   - Unexpected errors return 500 Internal Server Error

## Future Improvements

1. Add rate limiting
2. Implement caching for frequently split messages
3. Add more comprehensive logging
4. Add integration tests
5. Add API documentation using Swagger/OpenAPI
6. Add frontend application with React
7. Add Docker support
8. Add CI/CD pipeline

## Testing

Run the tests using:
```bash
mvn test
``` 