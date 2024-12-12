-- liquibase formatted sql

-- changeset nadimnesar:1
CREATE TABLE boards (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    is_closed BOOLEAN DEFAULT FALSE,
    is_webhook BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
-- rollback DROP TABLE boards;