package com.exabyting.exa_recruit.dto.exarecruitdb;

import com.exabyting.exa_recruit.constant.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String jwt;
    private String refreshToken;
    private UserRole userRole;
}
