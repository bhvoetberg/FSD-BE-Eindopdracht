INSERT INTO employees (id, function_name, first_name, last_name, enabled)
VALUES
(0, 'Supervisor', 'Rober', 'Voetberg', true),
(1, 'VPK', 'Freek', 'Frans', true);


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

INSERT INTO medicine (med_name, perilous, url_external_info, administer_method, dosage_form, instructions)
VALUES
    ('Paracetamol 500mg', false, 'onbekend', 'Oraal', 'Tablet', 'Geen'),
    ('Paracetamol 250mg', false, 'onbekend', 'Oraal', 'Tablet', 'Geen'),
    ('Oxazepam 500mg', true, 'onbekend', 'Oraal', 'Tablet', 'Geen');

INSERT INTO deviations (enabled, finding, resolution)
VALUES
    (false,'Bevinding 1', 'Oplossing 1'),
    (true,'Bevinding 2', 'Oplossing 2'),
    (true,'Bevinding 3', 'Oplossing 3');

INSERT INTO planning (enabled, quantity, plan_date, plan_time, deviation_id, medicine_id)
VALUES
    (true, 1, '15-1-2022', '08:00', 1, 2),
    (true, 1, '15-1-2022', '12:00', 2, 2),
    (true, 1, '15-1-2022', '16:00', null, 2),
    (true, 1, '15-1-2022', '20:00', 3, 2);






