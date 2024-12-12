-- liquibase formatted sql

-- changeset nadimnesar:7
CREATE TABLE card_members (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    card_id VARCHAR(255),
    member_id VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (card_id) REFERENCES cards(id),
    FOREIGN KEY (member_id) REFERENCES members(id)
);
-- rollback DROP TABLE card_members;