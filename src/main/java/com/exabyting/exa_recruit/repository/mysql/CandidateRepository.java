package com.exabyting.exa_recruit.repository.mysql;

import com.exabyting.exa_recruit.entity.mysql.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
