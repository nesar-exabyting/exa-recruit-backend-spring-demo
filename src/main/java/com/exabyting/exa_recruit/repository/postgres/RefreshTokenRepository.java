package com.exabyting.exa_recruit.repository.postgres;

import com.exabyting.exa_recruit.entity.postgres.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByToken(String refreshToken);
}
