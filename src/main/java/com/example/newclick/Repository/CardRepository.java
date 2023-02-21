package com.example.newclick.Repository;

import com.example.newclick.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "card")
public interface CardRepository extends JpaRepository<Card,Integer> {

    boolean existsCardByCardNumber(String cardNumber);

    Card getCardByCardNumber(String cardNumber);
}
