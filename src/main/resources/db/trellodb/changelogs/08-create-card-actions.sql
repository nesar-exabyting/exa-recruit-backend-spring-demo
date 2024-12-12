-- liquibase formatted sql

-- changeset nadimnesar:8
CREATE TABLE card_actions (
    id VARCHAR(255) NOT NULL,
    creator_member_id VARCHAR(255),
    board_id VARCHAR(255),
    card_id VARCHAR(255),
    list_id VARCHAR(255),
    before_list_id VARCHAR(255),
    after_list_id VARCHAR(255),
    text LONGTEXT,
    type TEXT,
    date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (creator_member_id) REFERENCES members(id),
    FOREIGN KEY (board_id) REFERENCES boards(id),
    FOREIGN KEY (card_id) REFERENCES cards(id),
    FOREIGN KEY (list_id) REFERENCES trello_lists(id),
    FOREIGN KEY (before_list_id) REFERENCES trello_lists(id),
    FOREIGN KEY (after_list_id) REFERENCES trello_lists(id)
);