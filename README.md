# Introductory task for internship  

### This application consists of several microservices:

2 microservices containing application logic:
 - user-service
 - company-service  

3 Spring Cloud microservices:
 - config-server
 - discovery-server
 - gateway

### Functionality of microservices

**user-service:**  
this microservice has 3 endpoints
 - /api/users/{userId}     --- getting a user by ID
 - /api/users/{lastName}     --- getting a user by Last Name
 - /api/users?ids=1,2,3      --- getting a users by IDs

**company-service:**  
this microservice has 2 endpoints
- /api/companies/{companyId}     --- getting a company by ID
- /api/companies/{name}     --- getting a company by name

### Installation and startup instructions

Download and build the project. To do this, after downloading, use the **"mvn clean package"** command to build.
Then you will need a **Docker**. Use the **"docker-compose up"** command to assemble the **images** into **containers**
and run them. The application will be available at **_https:/localhost:8222_**.
