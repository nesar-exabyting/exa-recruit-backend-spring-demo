package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToMany(mappedBy = "members")
    private List<Card> cards;

    @OneToMany(mappedBy = "member")
    private List<CardAction> cardActions;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}