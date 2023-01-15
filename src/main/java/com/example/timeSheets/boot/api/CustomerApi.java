package com.example.timeSheets.boot.api;

import com.example.timeSheets.boot.model.Customer;
import com.example.timeSheets.boot.model.Project;
import com.example.timeSheets.boot.service.CustomerService;
import com.example.timeSheets.boot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerApi {

    @Autowired
    private CustomerService service;


    @PostMapping
    public String save(@RequestBody Customer customer) {
        service.save(customer);
        return "Customer saved with success";
    }
    @GetMapping("/v2")
    public Page<Customer> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @PutMapping
    public String update(@RequestBody Customer customer) {
        service.save(customer);
        return "Customer updated with success";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        service.deleteById(customerId);
        return "Customer " + customerId + " Was deleted";
    }
}
