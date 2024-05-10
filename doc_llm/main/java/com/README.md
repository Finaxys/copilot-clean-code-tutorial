# Summary

The codebase for finaxys is a customer management system constructed using Spring Boot and Java. The system offers a RESTful API to handle customer operations, such as creation, retrieval, update, and deletion. Key components of the system include:

1. **Customer Model**: Comprising `CustomerDTO` for data transfer and `CustomerEntity` for database representation, both containing customer ID, first name, last name, and age properties.

2. **Customer Controller**: This component is responsible for managing HTTP requests associated with customers.

3. **Customer Mapper**: This module facilitates the conversion between `CustomerEntity` and `CustomerDTO` objects.

4. **Customer Repository**: This Spring Data JPA repository handles the persistence and retrieval of `CustomerEntity` objects from the database.

5. **Customer Service**: By utilizing the `CustomerRepository` for database operations and the `CustomerMapper` for data conversion, this component offers methods for managing customers.

The `EBusinessApplication` class serves as the entry point, starting and configuring the application automatically.

# Details

## finaxys

The provided codebase is a customer management system built using Spring Boot and Java. It consists of a RESTful API for managing customers, including endpoints for creating, retrieving, updating, and deleting customers. The system includes several components:

1. **Customer Model**: This includes `CustomerDTO` for data transfer and `CustomerEntity` for database representation, both containing properties for customer ID, first name, last name, and age.

2. **Customer Controller**: This handles HTTP requests related to customers.

3. **Customer Mapper**: This component converts between `CustomerEntity` and `CustomerDTO` objects.

4. **Customer Repository**: This is a Spring Data JPA repository for managing the persistence and retrieval of `CustomerEntity` objects in the database.

5. **Customer Service**: This uses the `CustomerRepository` for database operations and the `CustomerMapper` for data conversion, offering methods for managing customers.

The `EBusinessApplication` class starts and configures the application automatically.

