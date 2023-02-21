package com.example.newclick.service;

import com.example.newclick.Repository.CardRepository;
import com.example.newclick.Repository.IncomeRepository;
import com.example.newclick.Repository.OutcomeRepository;
import com.example.newclick.Result;
import com.example.newclick.dto.TransferDto;
import com.example.newclick.entity.Card;
import com.example.newclick.entity.Income;
import com.example.newclick.entity.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MoneyTransferService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    public Result moneyTransfer(TransferDto dto){
        if (!cardRepository.existsCardByCardNumber(dto.getFrom_card())){
            return new Result("From Card not found!",false, HttpStatus.NOT_FOUND);
        }
        Card fromCard = cardRepository.getCardByCardNumber(dto.getFrom_card());
        if (!cardRepository.existsCardByCardNumber(dto.getTo_card())){
            return new Result("To Card not found!",false, HttpStatus.NOT_FOUND);
        }
        Card toCard = cardRepository.getCardByCardNumber(dto.getTo_card());
        double summa=dto.getAmount();
        if (fromCard.getBalance()<(summa*1.01)){
            return new Result("There are not enough funds in this card!",false,HttpStatus.CONFLICT);
        }
        double a=fromCard.getBalance()-summa*1.01;
        fromCard.setBalance(a);
        cardRepository.save(fromCard);
        double s=toCard.getBalance()+summa;
        toCard.setBalance(s);
        cardRepository.save(toCard);
        Income income=new Income(null,fromCard,toCard,summa, LocalDateTime.now());
        incomeRepository.save(income);
        Outcome outcome=new Outcome(null,fromCard,toCard,summa,LocalDateTime.now(),summa*0.01);
        outcomeRepository.save(outcome);
        return new Result("Succesfill",true,HttpStatus.ACCEPTED);
    }
}
