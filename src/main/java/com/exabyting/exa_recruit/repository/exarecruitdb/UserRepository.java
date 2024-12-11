package com.exabyting.exa_recruit.repository.exarecruitdb;

import com.exabyting.exa_recruit.entity.exarecruitdb.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
