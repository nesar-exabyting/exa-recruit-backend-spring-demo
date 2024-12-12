package com.exabyting.exa_recruit.controller;

import com.exabyting.exa_recruit.dto.trellodb.CardDTO;
import com.exabyting.exa_recruit.entity.trellodb.Card;
import com.exabyting.exa_recruit.repository.trellodb.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {
    private final CardRepository cardRepository;

    public HelloController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {

        List<Card> cards = cardRepository.findAll();
        List<CardDTO> cardDTOS = new ArrayList<>();
        for(Card card : cards) {
            CardDTO cardDTO = new CardDTO();
            cardDTO.setId(card.getId());
            cardDTO.setName(card.getName());
            cardDTO.setBoard_id(card.getBoard().getId());
            cardDTO.setList_id(cardDTO.getList_id());
            cardDTO.setUrl(card.getUrl());
            cardDTO.setCustomField(card.getCustomField());
            cardDTO.setCreatedAt(card.getCreatedAt());
            cardDTO.setUpdatedAt(card.getUpdatedAt());
            cardDTOS.add(cardDTO);
        }

        return new ResponseEntity<>(cardDTOS, HttpStatus.OK);
    }
}