package com.example.timeSheets.boot.service;

import com.example.timeSheets.boot.model.Customer;
import com.example.timeSheets.boot.repository.CustomerRepository;
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
public class CustomerService {

    @Autowired
    private CustomerRepository repository;


    public void save(Customer customer) {
        repository.save(customer);

    }

    public Optional<Customer> findCustomer(Long customerId) {
        return repository.findById(customerId);
    }

    public List<Customer> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Customer> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
      return repository.findByNamev2("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }

    public void deleteById(Long customerId) {
        repository.deleteById(customerId);
    }
}
