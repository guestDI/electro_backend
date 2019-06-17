package com.electro.backend.repository;

import com.electro.backend.model.Application;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    @Modifying(clearAutomatically = true)
    @Query("Update Application app SET app.availability = :status WHERE app.id = :id")
    Integer updateApplicationStatus(@Param("id") Long itemId, @Param("status") boolean status);
}
