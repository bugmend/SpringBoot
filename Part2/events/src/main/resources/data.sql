INSERT INTO user (username, password, email, first_name, last_name, date_of_birth, role, phone_number, created_at, updated_at, is_active)
VALUES
    ('tina', 'password123', 'tina@example.com', 'Tina', 'Doe', '1990-01-01', 'USER', '1234567890', NOW(), NOW(), TRUE),
    ('mark', 'password456', 'mark@example.com', 'Mark', 'Doe', '1992-02-02', 'ADMIN', '0987654321', NOW(), NOW(), TRUE);



-- Inserting into the `venue` table
INSERT INTO venue (name, address, capacity, description) VALUES
                                                             ('Conference Center', '123 Main St, Cityville', 500, 'A large conference center with modern amenities.'),
                                                             ('Outdoor Park', '456 Park Ave, Townville', 1000, 'An open-air venue suitable for concerts and festivals.');

-- Inserting into the `event` table
-- Note: Replace `user_id` and `venue_id` with actual IDs from your user and venue tables
INSERT INTO event (name, description, start_time, end_time, venue_id, organizer_id) VALUES
                                                                                        ('Tech Conference 2024', 'Annual technology conference', '2024-09-15 09:00:00', '2024-09-16 17:00:00', 1, 1),
                                                                                        ('Music Festival', 'Live music festival with various artists', '2024-07-20 12:00:00', '2024-07-21 23:30:00', 2, 2);

-- Inserting into the `category` table
INSERT INTO category (name, description) VALUES
                                             ('Conferences', 'Events focused on professional conferences and seminars.'),
                                             ('Festivals', 'Outdoor festivals and large gatherings.');

-- Inserting into the `ticket` table
-- Note: Replace `event_id` and `user_id` with actual IDs from your event and user tables
INSERT INTO ticket (event_id, buyer_id, purchase_time, price, seat_number) VALUES
                                                                               (1, 1, NOW(), 99.99, 'A1'),
                                                                               (1, 2, NOW(), 99.99, 'A2'),
                                                                               (2, 1, NOW(), 59.99, 'GA');

-- Inserting many-to-many relations between `event` and `category`
-- Note: Replace `event_id` and `category_id` with actual IDs
INSERT INTO event_category (event_id, category_id) VALUES
                                                       (1, 1), -- Tech Conference 2024 in Conferences
                                                       (2, 2); -- Music Festival in Festivals
