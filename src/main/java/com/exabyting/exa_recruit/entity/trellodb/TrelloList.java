package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "trello_lists")
public class TrelloList {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "trelloList")
    private List<Card> cards;

    @OneToMany(mappedBy = "trelloList")
    private List<CardAction> cardActions;

    @Column(name = "name")
    private String name;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "color")
    private String color;

    @Column(name = "pos")
    private Integer pos;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}