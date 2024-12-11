package com.exabyting.exa_recruit.entity.trellodb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "labels")
public class Label {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToMany(mappedBy = "labels")
    private List<Card> cards;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "uses")
    private Integer uses;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}