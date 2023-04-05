CREATE TABLE orders (
  id BIGINT GENERATED ALWAYS AS IDENTITY,
  product_id BIGINT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO orders (product_id) VALUES (1.0);
INSERT INTO orders (product_id) VALUES (2.0);