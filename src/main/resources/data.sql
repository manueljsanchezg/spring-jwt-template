INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users (id, email, password, created_at, role_id)
VALUES (1, 'user@test.com','$2a$10$bureeATT02UJIY9v5anQieNrMi.DIgbG0PlgYFNgqZpUx2YjsUOki', NOW(), 1);

INSERT INTO users (id, email, password, created_at, role_id)
VALUES (2, 'admin@test.com', '$2a$10$bureeATT02UJIY9v5anQieNrMi.DIgbG0PlgYFNgqZpUx2YjsUOki', NOW(), 2);