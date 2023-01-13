package com.example.timeSheets.boot.service;

import com.example.timeSheets.boot.model.TimeSheet;
import com.example.timeSheets.boot.repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TimeSheetService {

    @Autowired
    private TimeSheetRepository repository;

    public void save(TimeSheet timeSheet) {
        repository.save(timeSheet);
    }

    public Page<TimeSheet> findAllByOrderByIdDesc(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findAllByOrderByIdDesc(pageable);
    }

    public Page<TimeSheet> findByEmployeeIdOrderByIdDesc(int pageNumber, int pageSize, Long employee){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repository.findByEmployeeIdOrderByIdDesc(pageable, employee);
    }

    public Optional<TimeSheet> findTimeSheet(Long timeSheetId) {
        return repository.findById(timeSheetId);
    }

    public void deleteById(Long timeSheetId) {
        repository.deleteById(timeSheetId);
    }

}
