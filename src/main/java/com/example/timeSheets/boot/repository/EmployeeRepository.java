package com.example.timeSheets.boot.repository;

import com.example.timeSheets.boot.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(nativeQuery = true , value = "select * from employee e where e.supervisor is not true and e.name like :searchTerm")
    Page<Employee> findByNamev2Employee(@Param("searchTerm") String searchTerm,Pageable pageable);
   @Query(nativeQuery = true , value = "select * from employee e where e.name like :searchTerm")
    Page<Employee> findByNv2Employee(@Param("searchTerm") String searchTerm,Pageable pageable);

}
