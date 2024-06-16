# Transaction App
This is a basic spring boot service which supports below operations
- Create account
- Get account details by account ID
- Create transaction

Create transaction API supports below operation types
1. Normal Purchase
2. Purchase with installments
3. Withdrawal
4. Credit Voucher

## Tech stack
- Java 17
- Spring boot 3.0
- H2 in-memory database

## Run commands
Use below command to run the application on your local
```bash
mvn spring-boot:run
```
Or
```bash
mvn install
java -jar target/transactions-app-0.0.1-SNAPSHOT.jar
```

## Docker 
Please refer Dockerfile
Use below scripts to build and run using docker.
```bash
docker build -t transaction-app .
docker run -p 8080:8080 transaction-app
```

## API documentation
Integration of swagger is present in this application. Run the application using any of the above methods and use below link to access the documentation.

http://localhost:8080/swagger-ui.html