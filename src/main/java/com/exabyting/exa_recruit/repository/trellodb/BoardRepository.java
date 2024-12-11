package com.exabyting.exa_recruit.repository.trellodb;

import com.exabyting.exa_recruit.entity.trellodb.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
}
