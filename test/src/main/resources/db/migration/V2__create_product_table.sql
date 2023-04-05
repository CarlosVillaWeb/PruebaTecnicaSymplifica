CREATE TABLE products (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name TEXT NOT NULL,
  price TEXT NOT NULL
);

INSERT INTO products (name, price) VALUES ('Product 1', '10.0');
INSERT INTO products (name, price) VALUES ('Product 2', '20.0');