package com.example.newclick.Repository;

import com.example.newclick.entity.Card;
import com.example.newclick.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user")
public interface UsersRepository extends JpaRepository<Users,Integer> {

    String getFullNameByCardIds(Card cardIds);
}
