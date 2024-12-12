package com.exabyting.exa_recruit.repository.trellodb;

import com.exabyting.exa_recruit.entity.trellodb.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

}
