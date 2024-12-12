package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbCard;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = DbCard.TABLE_NAME)
public class Card {
    @Id
    @Column(name = DbCard.ID)
    private String id;

    @ManyToOne
    @JoinColumn(name = DbCard.BOARD_ID)
    private Board board;

    @ManyToOne
    @JoinColumn(name = DbCard.LIST_ID)
    private TrelloList trelloList;

    @ManyToMany
    @JoinTable(
            name = DbCard.CARD_LABELS_JOIN_TABLE,
            joinColumns = @JoinColumn(name = DbCard.CARD_ID_JOIN_COLUMN),
            inverseJoinColumns = @JoinColumn(name = DbCard.LABEL_ID_INVERSE_COLUMN)
    )
    private List<Label> labels;

    @ManyToMany
    @JoinTable(
            name = DbCard.CARD_MEMBERS_JOIN_TABLE,
            joinColumns = @JoinColumn(name = DbCard.CARD_ID_JOIN_COLUMN),
            inverseJoinColumns = @JoinColumn(name = DbCard.MEMBER_ID_INVERSE_COLUMN)
    )
    private List<Member> members;

    @OneToMany(mappedBy = DbCard.CARD_RELATIONSHIP_FIELD)
    private List<CardAction> cardActions;

    @Column(name = DbCard.NAME)
    private String name;

    @Column(name = DbCard.DATE_LAST_ACTIVITY)
    private Date dateLastActivity;

    @Column(name = DbCard.IS_CLOSED)
    private Boolean isClosed;

    @Column(name = DbCard.URL)
    private String url;

    @Column(name = DbCard.CUSTOM_FIELD)
    private String customField;

    @Column(name = DbCard.CREATED_AT)
    private Date createdAt;

    @Column(name = DbCard.UPDATED_AT)
    private Date updatedAt;
}