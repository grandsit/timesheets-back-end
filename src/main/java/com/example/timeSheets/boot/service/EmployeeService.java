package com.example.timeSheets.boot.service;

import com.example.timeSheets.boot.model.Employee;
import com.example.timeSheets.boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public void save(Employee employee) {
        repository.save(employee);

    }
    public Page<Employee> findByNamev2Employee(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2Employee("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }

    public Page<Employee> findByNv2Employee(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNv2Employee("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }

//    public Page<Employee> findByNamev2Supervidor(Integer pageNumber, Integer pageSize, String searchTerm){
//        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
//        return repository.findByNamev2Supervidor("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
//    }
    public Optional<Employee> findEmployee(Long employeeId) {
        return repository.findById(employeeId);
    }

    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }

}
