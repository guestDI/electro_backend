package com.electro.backend.repository;

import com.electro.backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("Select u from User u where u.username = :username AND u.password = :password")
    User login(@Param("username") String username, @Param("password") String password);
}
