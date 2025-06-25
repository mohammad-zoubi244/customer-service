# Customer Service Microservice

A Spring Boot microservice responsible for managing customer data. This service is part of of Customer Orders microservices system demonstrating microservices architecture, RESTful API design, and cloud-ready deployment.

---

## 🧩 Features

- CRUD operations for customer entities
- RESTful APIs following best practices
- Spring Boot 3 with layered architecture
- PostgreSQL database integration
- Dockerized setup for containerization
- Clean, scalable codebase suitable for microservices environments

---

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## ⚙️ Getting Started

### Prerequisites

- Java 21
- Maven
- Docker
- Git

### Clone & Run

```bash
git clone https://github.com/mohammad-zoubi244/customer-service.git
cd customer-service
mvn clean install
```
Then, run the service (manually).
The service will be accessible at:
http://localhost:8082/customer

---

##  🔌 API Endpoints

| Method | Endpoint                                  | Description            |
| ------ | ----------------------------------------- | ---------------------- |
| GET    | /api/v1/customers                         | Retrieve all customers |
| GET    | /api/v1/customers/{customerId}            | Get a customer by ID   |
| POST   | /api/v1/customers                         | Create a new customer  |
| PUT    | /api/v1/customers/{customerId}            | Update customer info   |
| PATCH  | /api/v1/customers/{customerId}/deactivate | Deactivate a customer  |
| PATCH  | /api/v1/customers/{customerId}/activate   | Activate a customer    |
| DELETE | /api/v1/customers/{customerId}            | Delete a customer      |

---

## 📘 API Documentation (Swagger UI)
After running the service, access the API documentation here:

🔗 http://localhost:8082/customer/swagger-ui/index.html

- **Customer Service Swagger UI**: `http://localhost:8082/customer/swagger-ui/index.html`

---

## 🔮 Future Enhancements
 Add request validation

 Enable OpenAPI (Swagger) documentation

 Integrate with order-service via REST or messaging

 Add a Dockerfile for containerizing the service

 Add unit test coverage and CI/CD pipeline

 Add centralized logging (e.g., ELK stack)

 Add service registry and discovery (e.g., Eureka)

 ---

 ## 📄 License
This project is licensed under the MIT License.
You are free to use, modify, and distribute this software with proper attribution.
See the LICENSE file for more details.

 ---
##  👤 Author
Mohammad Zoubi
