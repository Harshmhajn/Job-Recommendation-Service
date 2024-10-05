# Database Design for Job Recommendation Service

## Introduction
This document outlines the database design for the Job Recommendation Service. The design supports efficient storage of user profiles and job postings while facilitating effective recommendations based on user preferences.

## Entity Overview
The database includes the following main entities:

1. **User**
    - Represents candidates looking for job opportunities.
    - Contains personal information, skills, experience level, and preferences.

2. **Job**
    - Represents job postings available in the system.
    - Includes job details such as title, company, required skills, location, job type, and experience level.

3. **Preferences**
    - Embedded within the User entity to represent user job preferences.
    - Includes desired roles, preferred locations, and job types.

## Database Tables

### 1. User Table
- **Table Name**: `user`
- **Description**: Stores information about users (candidates).

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `id`                 | BIGINT            | PRIMARY KEY, AUTO_INCREMENT | Unique identifier for each user      |
| `name`               | VARCHAR(255)      | NOT NULL                | Name of the user                      |
| `experience_level`   | VARCHAR(50)       | NOT NULL                | User's experience level               |

### 2. Job Table
- **Table Name**: `jobs`
- **Description**: Stores job postings.

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `id`                 | BIGINT            | PRIMARY KEY, AUTO_INCREMENT | Unique identifier for each job       |
| `title`              | VARCHAR(255)      | NOT NULL                | Title of the job                      |
| `company`            | VARCHAR(255)      | NOT NULL                | Company offering the job              |
| `location`           | VARCHAR(255)      | NOT NULL                | Job location                          |
| `job_type`           | VARCHAR(50)       | NOT NULL                | Type of job (e.g., full-time, part-time) |
| `experience_level`   | VARCHAR(50)       | NOT NULL                | Required experience level             |

### 3. Job Skills Table
- **Table Name**: `job_skills`
- **Description**: Stores the skills required for each job.

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `job_id`             | BIGINT            | FOREIGN KEY REFERENCES jobs(id) | References the job id                |
| `skill`              | VARCHAR(100)      | NOT NULL                | Skill required for the job            |

### 4. Desired Roles Table
- **Table Name**: `desired_roles`
- **Description**: Stores the desired roles for each user.

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `user_id`            | BIGINT            | FOREIGN KEY REFERENCES user(id) | References the user id                |
| `role`               | VARCHAR(100)      | NOT NULL                | Desired role of the user              |

### 5. Preferred Locations Table
- **Table Name**: `preferred_locations`
- **Description**: Stores the preferred locations for each user.

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `user_id`            | BIGINT            | FOREIGN KEY REFERENCES user(id) | References the user id                |
| `location`           | VARCHAR(100)      | NOT NULL                | Preferred location of the user        |

### 6. Candidate Skills Table
- **Table Name**: `candidate_skills`
- **Description**: Stores the skills of each user.

| Column Name          | Data Type         | Constraints             | Description                            |
|----------------------|-------------------|-------------------------|----------------------------------------|
| `candidate_id`       | BIGINT            | FOREIGN KEY REFERENCES user(id) | References the user id                |
| `skill`              | VARCHAR(100)      | NOT NULL                | Skill possessed by the user           |
