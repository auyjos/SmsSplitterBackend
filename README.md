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
- Console output for each split message (per assessment requirement)

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Setup and Running

1. Clone the repository
2. Navigate to the backend directory
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

---

## Design & Analytical Questions

### 1. Architecture Decisions
- **Project Structure:** The repository is organized into `backend/` (Spring Boot) and `frontend/` (React) directories for clear separation of concerns and easier deployment or scaling in the future.
- **Layered Backend:**
  - **Controller:** Handles HTTP requests and responses.
  - **Service:** Contains business logic for splitting SMS messages.
  - **Model:** Defines request/response data structures.
  - **Exception Handling:** Centralized with a global exception handler for consistent error responses.
- **Why this structure?**
  - Promotes maintainability, testability, and scalability.
  - Each layer has a single responsibility, making it easier to extend or refactor.
  - The separation between backend and frontend allows independent development and deployment.

### 2. API Design
- **RESTful Principles:**
  - The API exposes a single POST endpoint: `/api/v1/sms/split`.
  - Versioning (`/api/v1/`) is included to allow for future changes without breaking existing clients.
  - The API accepts a JSON payload with a `message` field and returns a JSON array of split messages.
- **Error Handling:**
  - Uses standard HTTP status codes:
    - `200 OK` for successful splits
    - `400 Bad Request` for validation errors
    - `500 Internal Server Error` for unexpected issues
  - Error responses are structured as JSON with clear messages for frontend consumption.
- **Why this design?**
  - It's simple, predictable, and easy to consume from any frontend or third-party client.
  - Versioning and structured errors make the API robust and future-proof.

### 3. State Management (Frontend)
- State is managed using React's `useState` hooks for simplicity and clarity.
- The split messages, input value, loading, and error states are all local to the form component.
- This approach is sufficient for a small app; for larger apps, a state management library (like Redux or Zustand) could be considered.

### 4. Security (If implemented)
- No authentication or authorization is implemented, as not required by the assessment.
- If needed, JWT-based authentication could be added, with tokens stored in HTTP-only cookies for security.

### 5. Scalability & Maintainability
- The backend is stateless and can be horizontally scaled behind a load balancer.
- The codebase is modular, making it easy to add new features (e.g., rate limiting, logging, or SMS provider integration).
- The frontend and backend can be deployed independently, supporting microservices or cloud-native architectures.
- For thousands of users, consider adding caching, database persistence, and asynchronous processing.

### 6. Time Constraints
- Skipped features include:
  - User authentication
  - Persistent storage of messages
  - Rate limiting and advanced monitoring
  - Full integration and E2E tests
  - Production-grade deployment (Docker, CI/CD)


### 7. Other Notable Decisions
- **Console Output:**
  - The backend prints each split message to the console to comply with the assessment's requirement to "display it on the console."
- **Frontend UX:**
  - Material UI is used for a modern, accessible, and responsive interface.
  - Character counter and part estimator help users understand SMS splitting in real time.
  - Error handling and loading states provide a smooth user experience.

---

## Future Improvements

1. Add rate limiting
2. Implement caching for frequently split messages
3. Add more comprehensive logging
4. Add integration tests
5. Add API documentation using Swagger/OpenAPI
6. Add Docker support
7. Add CI/CD pipeline

## Time & Effort

| Task                      | Time Spent |
|---------------------------|-----------:|
| Initial project setup     | 1 hr       |
| Core splitting logic      | 3 hrs      |
| API & controller wiring   | 2 hrs      |
| Frontend integration      | 2 hrs      |
| Validation & error paths  | 1 hr       |
| Unit tests                | 1 hr       |
| Documentation & README    | 1 hr       |
| **Total**                 | **11 hrs** |



Run the tests using:
```bash
mvn test
``` 
