package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "card_labels")
public class CardLabel {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "label_id")
    private String labelId;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Label label;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}