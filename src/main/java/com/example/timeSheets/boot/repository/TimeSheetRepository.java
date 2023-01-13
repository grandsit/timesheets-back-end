package com.example.timeSheets.boot.repository;

import com.example.timeSheets.boot.model.TimeSheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    Page<TimeSheet> findByEmployeeIdOrderByIdDesc(Pageable pageable, Long id);

    Page<TimeSheet> findAllByOrderByIdDesc(Pageable pageable);

}