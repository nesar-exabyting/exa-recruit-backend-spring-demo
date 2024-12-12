-- liquibase formatted sql

-- changeset nadimnesar:3
CREATE TABLE labels (
    id VARCHAR(255) NOT NULL,
    board_id VARCHAR(255),
    name VARCHAR(255),
    color VARCHAR(255),
    uses INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (board_id) REFERENCES boards(id)
);