package com.exabyting.exa_recruit.dto.exarecruitdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshDto {
    private String refreshToken;
}