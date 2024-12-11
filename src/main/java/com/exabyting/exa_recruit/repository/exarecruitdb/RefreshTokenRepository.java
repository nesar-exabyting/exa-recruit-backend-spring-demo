package com.exabyting.exa_recruit.repository.exarecruitdb;

import com.exabyting.exa_recruit.entity.exarecruitdb.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    RefreshToken findByToken(String refreshToken);
}
