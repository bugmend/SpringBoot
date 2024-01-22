INSERT INTO user (username, password, email, first_name, last_name, date_of_birth, role, phone_number, created_at, updated_at, is_active)
VALUES
    ('tina', 'password123', 'tina@example.com', 'Tina', 'Doe', '1990-01-01', 'USER', '1234567890', NOW(), NOW(), TRUE),
    ('mark', 'password456', 'mark@example.com', 'Mark', 'Doe', '1992-02-02', 'ADMIN', '0987654321', NOW(), NOW(), TRUE);