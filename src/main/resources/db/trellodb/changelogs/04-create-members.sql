-- liquibase formatted sql

-- changeset nadimnesar:4
CREATE TABLE members (
    id VARCHAR(255) NOT NULL,
    board_id VARCHAR(255),
    full_name VARCHAR(255),
    username VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (board_id) REFERENCES boards(id)
);
