package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbTrelloList;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = DbTrelloList.TABLE_NAME)
public class TrelloList {
    @Id
    @Column(name = DbTrelloList.ID)
    private String id;

    @ManyToOne
    @JoinColumn(name = DbTrelloList.BOARD_ID)
    private Board board;

    @OneToMany(mappedBy = DbTrelloList.TRELLO_LIST_RELATIONSHIP_FIELD)
    private List<Card> cards;

    @OneToMany(mappedBy = DbTrelloList.TRELLO_LIST_RELATIONSHIP_FIELD)
    private List<CardAction> cardActions;

    @Column(name = DbTrelloList.NAME)
    private String name;

    @Column(name = DbTrelloList.IS_CLOSED)
    private Boolean isClosed;

    @Column(name = DbTrelloList.COLOR)
    private String color;

    @Column(name = DbTrelloList.POS)
    private Integer pos;

    @Column(name = DbTrelloList.CREATED_AT)
    private Date createdAt;

    @Column(name = DbTrelloList.UPDATED_AT)
    private Date updatedAt;
}