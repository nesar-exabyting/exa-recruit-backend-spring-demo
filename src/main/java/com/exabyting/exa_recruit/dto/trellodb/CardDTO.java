package com.exabyting.exa_recruit.dto.trellodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private String id;

    private String board_id;

    private String list_id;

    private String name;

    private Date dateLastActivity;

    private Boolean isClosed;

    private String url;

    private String customField;

    private Date createdAt;

    private Date updatedAt;
}
