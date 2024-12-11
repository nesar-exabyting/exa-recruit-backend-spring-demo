-- Liquibase formatted SQL file

-- changeset nadimnesar:1
CREATE TABLE users (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    refresh_token_token_id BIGINT,
    PRIMARY KEY (user_id)
);

-- changeset nadimnesar:2
CREATE TABLE refresh_token (
    token_id BIGINT NOT NULL AUTO_INCREMENT,
    token VARCHAR(255) NOT NULL UNIQUE,
    expiry_date TIMESTAMP NOT NULL,
    user_user_id BIGINT,
    PRIMARY KEY (token_id)
);

-- changeset nadimnesar:3
ALTER TABLE refresh_token
ADD CONSTRAINT FK_user_to_token FOREIGN KEY (user_user_id) REFERENCES users (user_id) ON DELETE CASCADE;

-- changeset nadimnesar:4
ALTER TABLE users
ADD CONSTRAINT FK_token_to_user FOREIGN KEY (refresh_token_token_id) REFERENCES refresh_token (token_id) ON DELETE SET NULL;
