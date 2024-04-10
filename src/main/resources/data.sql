CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    age INT
);

INSERT INTO customer (first_name, last_name, age) VALUES ('Pierre', 'Johnson', 25);
INSERT INTO customer (first_name, last_name, age) VALUES ('François', 'Smith', 30);
INSERT INTO customer (first_name, last_name, age) VALUES ('Marie', 'Brown', 35);
INSERT INTO customer (first_name, last_name, age) VALUES ('Julie', 'Taylor', 40);
INSERT INTO customer (first_name, last_name, age) VALUES ('Luc', 'Anderson', 45);
INSERT INTO customer (first_name, last_name, age) VALUES ('Sophie', 'Williams', 50);
