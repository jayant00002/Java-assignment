# Java-assignment
# E-Commerce Wishlist Service

This service is part of the backend for an e-commerce platform. It manages user authentication and product wishlists, allowing users to save and track products they are interested in.

## Features

- **User Authentication**: Securely sign up and log in to the platform using JWT for session management.
- **Wishlist Management**: Add, retrieve, and delete items in a wishlist.

## Installation

### Prerequisites

- Java JDK 11
- Maven 3.6+
- MySQL 5.7+

### Setting Up the Development Environment

1. Clone the repository:
   ```sh
   git clone[ https://github.com/your-username/your-repo-name.git](https://github.com/jayant00002/Java-assignment)
 

2. Inside the application.properties file, update the datasource and JWT properties with your MySQL configurations and secret key.

3. Build the application using Maven:

4. Run the application:

## API Endpoints

The service exposes the following endpoints:

- `POST /auth/signup`: Register a new user account.
- `POST /auth/login`: Authenticate and receive an access token.
- `GET /api/wishlists`: Retrieve the current user's wishlist.
- `POST /api/wishlists`: Add an item to the wishlist.
- `DELETE /api/wishlists/{itemId}`: Remove an item from the wishlist.

## Running Tests

Execute the following command to run the unit tests:
```sh
mvn test


