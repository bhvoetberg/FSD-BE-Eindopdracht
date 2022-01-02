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

INSERT INTO clients (enabled, first_name, last_name, date_of_birth, photo, room_number, see_own_medication, tel_general_practitioner, tel_pharmacy)
VALUES
(false, 'Maecenas', 'Pellentesque', '1-1-1940', 'none', '101', true, '0123-456789', '0321-987654'),
(true, 'Sed', 'Melesuada', '1-2-1940', 'none', '102', true, '0123-456789', '0321-987654'),
(true, 'Lorem', 'Ipsum', '1-3-1940', 'none', '103', true, '0123-456789', '0321-987654'),
(true, 'Donec ', 'Vulputate', '1-3-1940', 'none', '104', true, '0123-456789', '0321-987654');


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

INSERT INTO planning (enabled, quantity, plan_date, plan_time, client_id, deviation_id, medicine_id)
VALUES
    (true, 1, '15-1-2022', '08:00', 2, 1, 1),
    (true, 1, '15-1-2022', '12:00', 1, 2, 2),
    (true, 1, '15-1-2022', '16:00', 2, null, 3),
    (true, 1, '15-1-2022', '20:00', 3, 3, 3);






