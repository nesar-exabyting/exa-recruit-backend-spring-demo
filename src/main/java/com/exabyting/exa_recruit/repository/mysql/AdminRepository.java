package com.exabyting.exa_recruit.repository.mysql;

import com.exabyting.exa_recruit.entity.mysql.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
