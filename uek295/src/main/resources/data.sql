
INSERT INTO address (address_id, country, plz, street)
VALUES
(1, 'Swiss', '1234', 'Hero'),
(2, 'Srbija', '1234', 'Mero'),
(3, 'Russia', '1234', 'Sero');

INSERT INTO role (role_name) VALUES ('ADMIN');
INSERT INTO role (role_name) VALUES ('USER');

INSERT INTO authority (authority_name) VALUES ('CREATE');
INSERT INTO authority (authority_name) VALUES ('READ');
INSERT INTO authority (authority_name) VALUES ('UPDATE');
INSERT INTO authority (authority_name) VALUES ('DELETE');

INSERT INTO users (username, password, user_role) VALUES ('ilija', '1234', 1);
INSERT INTO users (username, password, user_role) VALUES ('ruben', '1234', 1);
INSERT INTO users (username, password, user_role) VALUES ('dude', '1234', 2);

INSERT INTO role_authority VALUES (1, 1);
INSERT INTO role_authority VALUES (1, 2);
INSERT INTO role_authority VALUES (1, 3);
INSERT INTO role_authority VALUES (1, 4);
INSERT INTO role_authority VALUES (2, 2)