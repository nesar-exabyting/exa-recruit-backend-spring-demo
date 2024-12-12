-- liquibase formatted sql

-- changeset nadimnesar:2
CREATE TABLE trello_lists (
    id VARCHAR(255) NOT NULL,
    board_id VARCHAR(255),
    name VARCHAR(255),
    is_closed BOOLEAN DEFAULT FALSE,
    color VARCHAR(255),
    pos BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (board_id) REFERENCES boards(id)
);