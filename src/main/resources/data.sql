INSERT INTO employees (id, function_name, first_name, last_name, enabled)
VALUES
(1, 'Supervisor', 'Rober', 'Voetberg', true),
(2, 'VPK', 'Freek', 'Frans', true);


INSERT INTO users (username, password, enabled)
VALUES
    ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE),
    ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority)
VALUES ('employee', 'ROLE_EMPLOYEE'),
        ('admin', 'ROLE_EMPLOYEE'),
        ('admin', 'ROLE_ADMIN'),
        ('rober', 'ROLE_EMPLOYEE'),
        ('rober', 'ROLE_ADMIN'),
        ('user', 'ROLE_USER');

INSERT INTO planning (id, enabled, med_name, quantity, plan_date, plan_time)
VALUES
    (1, true, 'Paracetamol 500mg', 1, '15-1-2022', '08:00'),
    (2, true, 'Paracetamol 500mg', 1, '15-1-2022', '12:00'),
    (3, true, 'Paracetamol 500mg', 1, '15-1-2022', '16:00'),
    (4, true, 'Paracetamol 500mg', 1, '15-1-2022', '20:00');
