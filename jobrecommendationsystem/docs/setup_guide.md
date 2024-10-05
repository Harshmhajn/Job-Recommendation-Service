# Setup Guide for Job Recommendation Service

## Prerequisites
Before setting up the Job Recommendation Service, ensure you have the following installed:
- Java JDK (version 11 or higher)
- Apache Maven
- MySQL Database Server
- IntelliJ IDEA (optional but recommended for development)
- Postman for testing the Apis
## Clone the Repository
Clone the project repository to your local machine using the following command:
```bash
git clone https://github.com/Harshmhajn/jobrecommendation.git
cd jobrecommendation
```  
# Configure Database
CREATE DATABASE job_recommendation_db;
````
Update the database configuration in src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/job_recommendation_db
spring.datasource.username=your_username
spring.datasource.password=your_password
````