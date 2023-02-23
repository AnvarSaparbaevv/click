package com.example.newclick.service;

import com.example.newclick.Repository.IncomeRepository;
import com.example.newclick.entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;

    public Set<Income> getByIncome(Integer CardToId){
        Set<Income> set=new LinkedHashSet<>();
        for (Income income : incomeRepository.getIncomeByCardToId(CardToId)) {
            set.add(income);
        }
        return set;
    }
}
