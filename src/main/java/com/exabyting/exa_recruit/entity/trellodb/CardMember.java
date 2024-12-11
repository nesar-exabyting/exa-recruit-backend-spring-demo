package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "card_members")
public class CardMember {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "member_id")
    private String memberId;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Member member;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}