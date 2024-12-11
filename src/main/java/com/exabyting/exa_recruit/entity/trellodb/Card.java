package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TrelloList trelloList;

    @ManyToMany
    @JoinTable(
            name = "card_labels",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels;

    @ManyToMany
    @JoinTable(
            name = "card_members",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    @OneToMany(mappedBy = "card")
    private List<CardAction> cardActions;

    @Column(name = "name")
    private String name;

    @Column(name = "date_last_activity")
    private Date dateLastActivity;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "url")
    private String url;

    @Column(name = "custom_field", columnDefinition = "LONGTEXT")
    private String customField;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}