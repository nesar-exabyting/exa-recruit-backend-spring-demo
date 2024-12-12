package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbCardAction;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = DbCardAction.TABLE_NAME)
public class CardAction {
    @Id
    @Column(name = DbCardAction.ID)
    private String id;

    @ManyToOne
    @JoinColumn(name = DbCardAction.CREATOR_MEMBER_ID)
    private Member member;

    @Column(name = DbCardAction.TEXT)
    private String text;

    @ManyToOne
    @JoinColumn(name = DbCardAction.BOARD_ID)
    private Board board;

    @ManyToOne
    @JoinColumn(name = DbCardAction.CARD_ID)
    private Card card;

    @ManyToOne
    @JoinColumn(name = DbCardAction.LIST_ID)
    private TrelloList trelloList;

    @ManyToOne
    @JoinColumn(name = DbCardAction.BEFORE_LIST_ID)
    private TrelloList beforeTrelloList;

    @ManyToOne
    @JoinColumn(name = DbCardAction.AFTER_LIST_ID)
    private TrelloList afterTrelloList;

    @Column(name = DbCardAction.TYPE)
    private String type;

    @Column(name = DbCardAction.DATE)
    private Date date;

    @Column(name = DbCardAction.CREATED_AT)
    private Date createdAt;

    @Column(name = DbCardAction.UPDATED_AT)
    private Date updatedAt;
}