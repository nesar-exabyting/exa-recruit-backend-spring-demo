-- liquibase formatted sql

-- changeset nadimnesar:5
CREATE TABLE cards (
    id VARCHAR(255) NOT NULL,
    board_id VARCHAR(255),
    list_id VARCHAR(255),
    name VARCHAR(255),
    date_last_activity TIMESTAMP,
    is_closed BOOLEAN DEFAULT FALSE,
    url VARCHAR(255),
    custom_field LONGTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (board_id) REFERENCES boards(id),
    FOREIGN KEY (list_id) REFERENCES trello_lists(id)
);
