DROP TABLE IF EXISTS order_entry;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    stock_quantity INT NOT NULL,
    price DECIMAL NOT NULL
);

CREATE TABLE orders
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    original_order_id VARCHAR(15) NOT NULL,
    status VARCHAR(15)
);

CREATE TABLE order_entry
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    ordered_qty INT NOT NULL,
    order_entry_price DECIMAL(10, 2) NOT NULL,

    FOREIGN KEY (order_id)
        REFERENCES orders (id),

    FOREIGN KEY (product_id)
        REFERENCES products (id)
);

INSERT INTO products (name, stock_quantity, price)
VALUES
    ('pen', 10, 0.99),
    ('book', 5, 4.99),
    ('ps5', 1, 800);

INSERT INTO orders (original_order_id, status)
VALUES
    ('114-14345-12', 'created');

INSERT INTO order_entry (order_id, product_id, ordered_qty, order_entry_price)
VALUES
    (1, 1, 5, 0.99);