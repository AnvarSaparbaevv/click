package com.example.newclick.Repository;

import com.example.newclick.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path = "income")
public interface IncomeRepository extends JpaRepository<Income,Integer> {

    Set<Income> getIncomeByTo_cord_id(String to_card_id);
}
