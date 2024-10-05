# Job Recommendation Service Backend

Welcome to the Job Recommendation Service backend! This project aims to provide a robust backend solution that recommends job postings to users based on their profiles and preferences. The service is built using Java, Spring Boot, and MySQL, ensuring a solid foundation for handling user data and job listings.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Database Design](#database-design)
- [API Endpoints](#api-endpoints)
- [Recommendation Logic](#recommendation-logic)
- [Error Handling](#error-handling)
- [Setup Instructions](#setup-instructions)


## Features
- **User Management**: Create, update, and delete user profiles.
- **Job Management**: Manage job postings with relevant details.
- **Job Recommendations**: Suggest job postings to users based on their skills, experience, and preferences.
- **Error Handling**: Comprehensive error handling for robust API responses.

## Technologies Used
- **Java**: The primary programming language.
- **Spring Boot**: Framework for building RESTful APIs.
- **MySQL**: Relational database for storing user profiles and job postings.
- **Lombok**: Used for reducing boilerplate code with annotations.

## Database Design
The database is designed to efficiently store user profiles and job postings. Below is a summary of the key entities:

### User
- **ID**: Unique identifier for each user.
- **Name**: The user's name.
- **Skills**: List of skills associated with the user.
- **Experience Level**: The user's experience level (e.g., Junior, Intermediate, Senior).
- **Preferences**: Contains user preferences for desired roles, locations, and job types.

### Job
- **ID**: Unique identifier for each job.
- **Title**: The title of the job position.
- **Company**: Name of the hiring company.
- **Skills Required**: List of skills required for the job.
- **Location**: Job location.
- **Job Type**: Type of employment (e.g., Full-Time, Part-Time).
- **Experience Level**: Required experience level for applicants.

### Preferences (Embedded in User)
- **Desired Roles**: List of roles the user is interested in.
- **Locations**: Preferred job locations.
- **Job Type**: Desired job type.

## API Endpoints
The backend service provides several RESTful API endpoints:

### User Endpoints
- `GET /api/users`: Retrieve all users.
- `POST /api/users`: Create a new user.
- `GET /api/users/{id}`: Get user details by ID.
- `PUT /api/users/{id}`: Update user details.
- `DELETE /api/users/{id}`: Delete a user.

### Job Endpoints
- `GET /api/jobs`: Retrieve all job postings.
- `POST /api/jobs`: Create a new job posting.
- `GET /api/jobs/{id}`: Get job details by ID.
- `DELETE /api/jobs/{id}`: Delete a job posting.
- `GET /api/users/getRecommendation/{id}`: Get job recommendations for a user.

## Recommendation Logic
The job recommendation logic is based on matching user profiles with job postings. It considers the following factors:
- Skills: The service matches user skills with required skills for jobs.
- Experience Level: Recommendations are tailored based on the user's experience level and the job's requirements.
- Preferences: User preferences for desired roles, locations, and job types influence the recommendations.

## Error Handling
The backend includes robust error handling using global exception handling. This ensures that all API responses are meaningful and provide useful feedback to the client.

## Setup Instructions
To run the Job Recommendation Service backend locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Harshmhajn/job-recommendation-service.git
   cd job-recommendation-service

2.Set up the database:

Ensure MySQL is running.
Create a database named job_recommendation.
Update the application.properties file with your database credentials.

3.Run the application:

Use your preferred IDE (e.g., IntelliJ IDEA) to run the Spring Boot application.
The application will start on http://localhost:8080.