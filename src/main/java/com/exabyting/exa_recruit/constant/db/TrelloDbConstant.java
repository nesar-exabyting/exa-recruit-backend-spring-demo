package com.exabyting.exa_recruit.constant.db;

import lombok.Data;

@Data
public class TrelloDbConstant {
    private TrelloDbConstant() {
    }

    public static class DbCommon {
        public static final String ID = "id";
        public static final String CREATED_AT = "created_at";
        public static final String UPDATED_AT = "updated_at";

        DbCommon(){
        }
    }

    public static class DbBoard extends DbCommon {
        public static final String TABLE_NAME = "boards";
        public static final String NAME = "name";
        public static final String IS_CLOSED = "is_closed";
        public static final String IS_WEBHOOK = "is_webhook";
        public static final String BOARD_RELATIONSHIP_FIELD = "board";
    }

    public static class DbCard extends DbCommon {
        public static final String TABLE_NAME = "cards";
        public static final String BOARD_ID = "board_id";
        public static final String LIST_ID = "list_id";
        public static final String NAME = "name";
        public static final String DATE_LAST_ACTIVITY = "date_last_activity";
        public static final String IS_CLOSED = "is_closed";
        public static final String URL = "url";
        public static final String CUSTOM_FIELD = "custom_field";
        public static final String CARD_RELATIONSHIP_FIELD = "card";
        public static final String CARD_LABELS_JOIN_TABLE = "card_labels";
        public static final String CARD_ID_JOIN_COLUMN = "card_id";
        public static final String LABEL_ID_INVERSE_COLUMN = "label_id";
        public static final String CARD_MEMBERS_JOIN_TABLE = "card_members";
        public static final String MEMBER_ID_INVERSE_COLUMN = "member_id";
    }

    public static class DbCardAction extends DbCommon {
        public static final String TABLE_NAME = "card_actions";
        public static final String CREATOR_MEMBER_ID = "creator_member_id";
        public static final String TEXT = "text";
        public static final String BOARD_ID = "board_id";
        public static final String CARD_ID = "card_id";
        public static final String LIST_ID = "list_id";
        public static final String BEFORE_LIST_ID = "before_list_id";
        public static final String AFTER_LIST_ID = "after_list_id";
        public static final String TYPE = "type";
        public static final String DATE = "date";
    }

    public static class DbCardLabel extends DbCommon {
        public static final String TABLE_NAME = "card_labels";
        public static final String CARD_ID = "card_id";
        public static final String LABEL_ID = "label_id";
    }

    public static class DbCardMember extends DbCommon {
        public static final String TABLE_NAME = "card_members";
        public static final String CARD_ID = "card_id";
        public static final String MEMBER_ID = "member_id";
    }

    public static class DbLabel extends DbCommon {
        public static final String TABLE_NAME = "labels";
        public static final String BOARD_ID = "board_id";
        public static final String NAME = "name";
        public static final String COLOR = "color";
        public static final String USES = "uses";
        public static final String LABELS_RELATIONSHIP_FIELD = "labels";
    }

    public static class DbMember extends DbCommon {
        public static final String TABLE_NAME = "members";
        public static final String BOARD_ID = "board_id";
        public static final String USERNAME = "username";
        public static final String FULL_NAME = "full_name";
        public static final String MEMBERS_RELATIONSHIP_FIELD = "members";
        public static final String MEMBER_RELATIONSHIP_FIELD = "member";
    }

    public static class DbTrelloList extends DbCommon {
        public static final String TABLE_NAME = "trello_lists";
        public static final String BOARD_ID = "board_id";
        public static final String NAME = "name";
        public static final String COLOR = "color";
        public static final String IS_CLOSED = "is_closed";
        public static final String POS = "pos";
        public static final String TRELLO_LIST_RELATIONSHIP_FIELD = "trelloList";
    }
}