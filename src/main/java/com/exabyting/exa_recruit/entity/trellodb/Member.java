package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbMember;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = DbMember.TABLE_NAME)
public class Member {
    @Id
    @Column(name = DbMember.ID)
    private String id;

    @ManyToOne
    @JoinColumn(name = DbMember.BOARD_ID)
    private Board board;

    @ManyToMany(mappedBy = DbMember.MEMBERS_RELATIONSHIP_FIELD)
    private List<Card> cards;

    @OneToMany(mappedBy = DbMember.MEMBER_RELATIONSHIP_FIELD)
    private List<CardAction> cardActions;

    @Column(name = DbMember.FULL_NAME)
    private String fullName;

    @Column(name = DbMember.USERNAME)
    private String username;

    @Column(name = DbMember.CREATED_AT)
    private Date createdAt;

    @Column(name = DbMember.UPDATED_AT)
    private Date updatedAt;
}