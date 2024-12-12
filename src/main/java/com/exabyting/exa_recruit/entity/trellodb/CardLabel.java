package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbCardLabel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = DbCardLabel.TABLE_NAME)
public class CardLabel {
    @Id
    @Column(name = DbCardLabel.ID)
    private Long id;

    @Column(name = DbCardLabel.CARD_ID)
    private String cardId;

    @Column(name = DbCardLabel.LABEL_ID)
    private String labelId;

    @ManyToOne
    @JoinColumn(name = DbCardLabel.CARD_ID, referencedColumnName = DbCardLabel.ID, insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = DbCardLabel.LABEL_ID, referencedColumnName = DbCardLabel.ID, insertable = false, updatable = false)
    private Label label;

    @Column(name = DbCardLabel.CREATED_AT)
    private Date createdAt;

    @Column(name = DbCardLabel.UPDATED_AT)
    private Date updatedAt;
}