package com.cleo.project1practice.repositories;

import com.cleo.project1practice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,  Long> {

    User getByUsername(String name);


}
