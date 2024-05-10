# Summary

The Finaxys codebase is a customer management system developed using Spring Boot and Java. It exposes a RESTful API for handling customer operations such as creation, retrieval, update, and deletion. The key components of the system are:

1. **Customer Model**: Consists of `CustomerDTO` for data transfer and `CustomerEntity` for database representation. Both contain properties for customer ID, first name, last name, and age.
2. **Customer Controller**: Handles HTTP requests related to customers.
3. **Customer Mapper**: Facilitates the conversion between `CustomerEntity` and `CustomerDTO` objects.
4. **Customer Repository**: A Spring Data JPA repository that manages the persistence and retrieval of `CustomerEntity` objects from the database.
5. **Customer Service**: Uses `CustomerRepository` for database operations and `CustomerMapper` for data conversion, offering methods for managing customers.

The `EBusinessApplication` class serves as the application's entry point, handling startup and configuration.

Resources:

1. **application.yml**: A Spring Boot configuration file that sets up an in-memory H2 database for the application, defines the application context path, and enables the H2 console for database inspection.
2. **data.sql**: A SQL script that creates a "customer" table with columns for customer ID, first name, last name, and age, and inserts six records into the table.

The application uses the H2 database, and the schema is updated automatically whenever the application starts. The API endpoints start with "/api/v1".

# Details

## java

The finaxys codebase is a customer management system built using Spring Boot and Java. It provides a RESTful API for handling customer operations like creation, retrieval, update, and deletion. The system includes several key components:

1. **Customer Model**: This consists of `CustomerDTO` for data transfer and `CustomerEntity` for database representation. Both contain properties for customer ID, first name, last name, and age.

2. **Customer Controller**: This component handles HTTP requests related to customers.

3. **Customer Mapper**: This module facilitates the conversion between `CustomerEntity` and `CustomerDTO` objects.

4. **Customer Repository**: This Spring Data JPA repository manages the persistence and retrieval of `CustomerEntity` objects from the database.

5. **Customer Service**: This component uses `CustomerRepository` for database operations and `CustomerMapper` for data conversion, offering methods for managing customers.

The `EBusinessApplication` class acts as the application's entry point, handling its startup and configuration.

## resources

The `application.yml` file is a configuration for a Spring Boot application. It sets up an in-memory H2 database for the application, with the database URL, username, and driver class name specified. The JPA database platform is set to H2Dialect, and the Hibernate ddl-auto property is set to "update", which means the schema will be updated automatically whenever the application starts. The H2 console is enabled for database inspection.

The servlet context path is set to "/api/v1", which means all the API endpoints will start with this path.

The `data.sql` file contains SQL code that creates a table named "customer" with columns for a unique customer identifier (customer_id), first name (first_name), last name (last_name), and age (age). The customer_id column is set to automatically assign a unique number to each new record. After creating the table, the code inserts six records into the "customer" table with the specified first names, last names, and ages. Each record does not have a defined customer_id as it is automatically assigned by the SERIAL keyword.

