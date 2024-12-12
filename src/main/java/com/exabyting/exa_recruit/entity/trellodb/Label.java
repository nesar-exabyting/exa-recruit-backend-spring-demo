package com.exabyting.exa_recruit.entity.trellodb;

import com.exabyting.exa_recruit.constant.db.TrelloDbConstant.DbLabel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = DbLabel.TABLE_NAME)
public class Label {
    @Id
    @Column(name = DbLabel.ID)
    private String id;

    @ManyToOne
    @JoinColumn(name = DbLabel.BOARD_ID)
    private Board board;

    @ManyToMany(mappedBy = DbLabel.LABELS_RELATIONSHIP_FIELD)
    private List<Card> cards;

    @Column(name = DbLabel.NAME)
    private String name;

    @Column(name = DbLabel.COLOR)
    private String color;

    @Column(name = DbLabel.USES)
    private Integer uses;

    @Column(name = DbLabel.CREATED_AT)
    private Date createdAt;

    @Column(name = DbLabel.UPDATED_AT)
    private Date updatedAt;
}