INSERT INTO employees (id, function_name, first_name, last_name, enabled)
VALUES
(1, 'Supervisor', 'Aap', 'Noot', true);

INSERT INTO users (username, password, enabled)
VALUES
    ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE),
    ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN'),
    ('peter', 'ROLE_USER'),
    ('peter', 'ROLE_ADMIN');