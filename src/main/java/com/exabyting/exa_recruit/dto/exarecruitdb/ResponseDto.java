package com.exabyting.exa_recruit.dto.exarecruitdb;

import com.exabyting.exa_recruit.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String jwt;
    private String refreshToken;
    private UserRole userRole;
}
