package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbCardMember;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = DbCardMember.TABLE_NAME)
public class CardMember {
    @Id
    @Column(name = DbCardMember.ID)
    private Long id;

    @Column(name = DbCardMember.CARD_ID)
    private String cardId;

    @Column(name = DbCardMember.MEMBER_ID)
    private String memberId;

    @ManyToOne
    @JoinColumn(name = DbCardMember.CARD_ID, referencedColumnName = DbCardMember.ID, insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name =  DbCardMember.MEMBER_ID, referencedColumnName = DbCardMember.ID, insertable = false, updatable = false)
    private Member member;

    @Column(name = DbCardMember.CREATED_AT)
    private Date createdAt;

    @Column(name = DbCardMember.UPDATED_AT)
    private Date updatedAt;
}