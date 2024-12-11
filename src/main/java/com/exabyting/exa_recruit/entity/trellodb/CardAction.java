package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "card_actions")
public class CardAction {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "creator_member_id")
    private Member member;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TrelloList trelloList;

    @ManyToOne
    @JoinColumn(name = "before_list_id")
    private TrelloList beforeTrelloList;

    @ManyToOne
    @JoinColumn(name = "after_list_id")
    private TrelloList afterTrelloList;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Date date;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}