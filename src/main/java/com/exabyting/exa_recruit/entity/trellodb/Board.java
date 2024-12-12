package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbBoard;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = DbBoard.TABLE_NAME)
public class Board {
    @Id
    @Column(name = DbBoard.ID)
    private String id;

    @Column(name = DbBoard.NAME)
    private String name;

    @Column(name = DbBoard.IS_CLOSED)
    private Boolean isClosed;

    @Column(name = DbBoard.IS_WEBHOOK)
    private Boolean isWebhook;

    @OneToMany(mappedBy = DbBoard.BOARD_RELATIONSHIP_FIELD)
    private List<TrelloList> trelloList;

    @OneToMany(mappedBy = DbBoard.BOARD_RELATIONSHIP_FIELD)
    private List<Card> cards;

    @OneToMany(mappedBy = DbBoard.BOARD_RELATIONSHIP_FIELD)
    private List<Label> labels;

    @OneToMany(mappedBy = DbBoard.BOARD_RELATIONSHIP_FIELD)
    private List<Member> members;

    @OneToMany(mappedBy = DbBoard.BOARD_RELATIONSHIP_FIELD)
    private List<CardAction> cardActions;

    @Column(name = DbBoard.CREATED_AT)
    private Date createdAt;

    @Column(name = DbBoard.UPDATED_AT)
    private Date updatedAt;
}