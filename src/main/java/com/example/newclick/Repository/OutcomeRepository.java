package com.example.newclick.Repository;

import com.example.newclick.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "outcome")
public interface OutcomeRepository extends JpaRepository<Outcome,Integer> {
}
