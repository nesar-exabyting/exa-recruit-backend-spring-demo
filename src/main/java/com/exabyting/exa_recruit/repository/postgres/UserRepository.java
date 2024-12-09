package com.exabyting.exa_recruit.repository.postgres;

import com.exabyting.exa_recruit.entity.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
