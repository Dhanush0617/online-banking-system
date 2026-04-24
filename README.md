# Online Banking System

A secure REST API for core banking operations built with Java and Spring Boot.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA + Hibernate
- MySQL
- Maven
- Postman (API Testing)

## How to Run
1. Clone the repo
2. Create MySQL database: `CREATE DATABASE bankingdb;`
3. Update `src/main/resources/application.properties` with your DB password
4. Run: `mvn spring-boot:run`
5. API runs at: `http://localhost:8081/api/accounts`

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/accounts | Create account |
| GET | /api/accounts | Get all accounts |
| GET | /api/accounts/{id} | Get account by ID |
| PUT | /api/accounts/{id}/deposit | Deposit money |
| PUT | /api/accounts/{id}/withdraw | Withdraw money |
| POST | /api/accounts/transfer | Transfer money |
| DELETE | /api/accounts/{id} | Delete account |

## Sample Request (POST)
```json
{
  "holderName": "Dhanush",
  "accountNumber": "ACC001",
  "balance": 10000,
  "accountType": "SAVINGS"
}
```
