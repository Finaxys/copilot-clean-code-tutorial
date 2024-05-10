# Summary

The `application.yml` file is a configuration for a Spring Boot application. It sets up an in-memory H2 database for the application, with the database URL, username, and driver class name specified. The JPA database platform is set to H2Dialect, and the Hibernate ddl-auto property is set to "update", which means the schema will be updated automatically whenever the application starts. The H2 console is enabled for database inspection.

The servlet context path is set to "/api/v1", which means all the API endpoints will start with this path.

The `data.sql` file contains SQL code that creates a table named "customer" with columns for a unique customer identifier (customer_id), first name (first_name), last name (last_name), and age (age). The customer_id column is set to automatically assign a unique number to each new record. After creating the table, the code inserts six records into the "customer" table with the specified first names, last names, and ages. Each record does not have a defined customer_id as it is automatically assigned by the SERIAL keyword.

# Details

## application.yml

This code snippet is a configuration for a Spring Boot application, specifically for the database connection and server settings.

For the database connection, it uses an in-memory H2 database with the database URL, username, and driver class name specified. The JPA database platform is set to H2Dialect, and the Hibernate ddl-auto property is set to "update", which means the schema will be updated automatically whenever the application starts. The H2 console is enabled, allowing database inspection.

For the server settings, it sets the servlet context path to "/api/v1", which means all the API endpoints will start with this path.

## data.sql

This SQL code creates a table named "customer" with the following columns:

1. customer_id: This is a unique identifier for each customer. The SERIAL keyword automatically assigns a unique number to each new record. It is also set as the PRIMARY KEY, which means it is used to uniquely identify each record in the table.

2. first_name: This column stores the first name of the customer. It is a VARCHAR type, which means it can store strings of up to 255 characters.

3. last_name: This column stores the last name of the customer. It is also a VARCHAR type and can store strings of up to 255 characters.

4. age: This column stores the age of the customer. It is an INT type, which means it can store integers.

After creating the table, the code inserts six records into the "customer" table with the specified first names, last names, and ages. Each record does not have a defined customer_id as it is automatically assigned by the SERIAL keyword.

