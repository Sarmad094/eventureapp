# Eventure Backend

Eventure is a backend API for an event booking platform, built with Spring Boot and PostgreSQL. It supports functionality for students, organizations, events, bookings, payments, and more.

## Technologies

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Jakarta Persistence API
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12 or later
- Git

### Installation

1. Clone the repository:  
   `git clone https://github.com/username/eventure-backend.git`

2. Navigate to the project directory:  
   `cd eventure-backend`

3. Install dependencies with Maven:  
   `mvn clean install`

4. Create a local PostgreSQL database:  
   `createdb eventureappdb`

5. Configure the database connection in `src/main/resources/application.properties`:


6. Start the server:  
   `mvn spring-boot:run`

The API will be available at: `http://localhost:8081`

## API Endpoints

### Students

- `GET /api/students`
- `GET /api/students/{id}`
- `POST /api/students`
- `POST /api/students/login`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`

### Organizations

- `GET /api/organizations`
- `GET /api/organizations/{id}`
- `POST /api/organizations/register`
- `POST /api/organizations/login`
- `PUT /api/organizations/{id}`
- `DELETE /api/organizations/{id}`

### Events

- `GET /api/events`
- `GET /api/events/{id}`
- `POST /api/events`
- `PUT /api/events/{id}`
- `DELETE /api/events/{id}`

### Bookings

- `GET /api/bookings`
- `GET /api/bookings/{id}`
- `POST /api/bookings`
- `PUT /api/bookings/{id}`
- `DELETE /api/bookings/{id}`

### Payments

- `GET /api/payments`
- `GET /api/payments/{id}`
- `POST /api/payments`
- `PUT /api/payments/{id}`
- `DELETE /api/payments/{id}`
- `GET /api/payments/book/{bookingId}`

### Liked Events

- `GET /api/likedevents`
- `GET /api/likedevents/{studentId}`
- `POST /api/likedevents/like?studentId={id}&eventId={id}`
- `DELETE /api/likedevents/unlike?studentId={id}&eventId={id}`
- `GET /api/likedevents/exists?studentId={id}&eventId={id}`

### Reference Data

**Locations**

- `GET /api/locations`
- `GET /api/locations/{id}`
- `POST /api/locations`
- `PUT /api/locations/{id}`
- `DELETE /api/locations/{id}`

**Fields**

- `GET /api/fields`
- `GET /api/fields/{id}`
- `POST /api/fields`
- `PUT /api/fields/{id}`
- `DELETE /api/fields/{id}`

### Confirmations

- `GET /api/confirmations`
- `GET /api/confirmations/{id}`
- `POST /api/confirmations`
- `PUT /api/confirmations/{id}`
- `DELETE /api/confirmations/{id}`

## Database Schema (PostgreSQL)

```sql
CREATE TABLE student (
    studentid BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phonenumber VARCHAR(20),
    university VARCHAR(255),
    s_field VARCHAR(255),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE organization (
    org_id BIGINT PRIMARY KEY,
    org_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    o_field VARCHAR(255),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE field (
    field_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    field_name VARCHAR(255) NOT NULL,
    f_description TEXT
);

CREATE TABLE location (
    location_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    locationname VARCHAR(255) NOT NULL
);

CREATE TABLE event (
    event_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(255) NOT NULL,
    e_description TEXT,
    participants INT,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price DECIMAL(10,2),
    org_id BIGINT REFERENCES organization(org_id),
    field_id BIGINT REFERENCES field(field_id),
    location_id INT REFERENCES location(location_id)
);

CREATE TABLE booking (
    bookid INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    bookdate VARCHAR(255),
    paymentstatus BOOLEAN,
    event_id BIGINT REFERENCES event(event_id),
    studentid BIGINT REFERENCES student(studentid)
);

CREATE TABLE payment (
    paymentid BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    amount DECIMAL(10,2) NOT NULL,
    paymentdate DATE NOT NULL,
    cardname VARCHAR(255),
    bookid INT REFERENCES booking(bookid)
);

CREATE TABLE likedevent (
    studentid BIGINT REFERENCES student(studentid),
    eventid BIGINT REFERENCES event(event_id),
    PRIMARY KEY (studentid, eventid)
);

CREATE TABLE confirmation (
    confirmationid INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    bookid INT REFERENCES booking(bookid),
    confirmationdate DATE,
    emailsent BOOLEAN
);

mvn test

mvn test jacoco:report

mvn test -Dtest="*UnitTest"

docker build -t eventure-backend .

docker run -p 8081:8081 --env-file .env eventure-backend

mvn clean package

java -jar target/eventureapp-0.0.1-SNAPSHOT.jar

src/main/java/com/example/eventureapp/
├── Config/             # Web configuration (CORS, etc.)
├── Controller/         # REST controllers
├── DTO/                # Data Transfer Objects
├── Mapper/             # Entity-to-DTO mappers
├── Model/              # JPA entities
├── Repository/         # Spring Data JPA repositories
├── Service/            # Business logic
└── EventureappApplication.java  # Main Spring Boot class



