-- liquibase formatted sql

-- changeset nadimnesar:6
CREATE TABLE card_labels (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    card_id VARCHAR(255),
    label_id VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (card_id) REFERENCES cards(id),
    FOREIGN KEY (label_id) REFERENCES labels(id)
);
-- rollback DROP TABLE card_labels;