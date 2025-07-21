DROP TABLE IF EXISTS reservations;

CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(255) NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL
);

INSERT INTO reservations (guest_name, check_in, check_out) VALUES
 ('Taro Yamada', '2025-08-01', '2025-08-05'),
 ('Jane Smith',  '2025-09-10', '2025-09-12');