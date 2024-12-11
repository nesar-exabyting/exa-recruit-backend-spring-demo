package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "boards")
public class Board {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "is_webhook")
    private Boolean isWebhook;

    @OneToMany(mappedBy = "board")
    private List<TrelloList> trelloList;

    @OneToMany(mappedBy = "board")
    private List<Card> cards;

    @OneToMany(mappedBy = "board")
    private List<Label> labels;

    @OneToMany(mappedBy = "board")
    private List<Member> members;

    @OneToMany(mappedBy = "board")
    private List<CardAction> cardActions;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}