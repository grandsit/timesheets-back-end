package com.example.timeSheets.boot.repository;

import com.example.timeSheets.boot.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "select c from Project c where c.projectName ilike :searchTerm")
    Page<Project> findByNamev2(@Param("searchTerm") String searchTerm, Pageable pageable);


    @Query(value ="select p from Project  p where p.id = :id")
    Project findByProjectId(@Param("id") Long id);

    @Query(value ="select count(*)> 0 from project p where p.id = :id and p.customer_id is not null",nativeQuery = true)
    Boolean existsCustomer(@Param("id") Long id);
}
