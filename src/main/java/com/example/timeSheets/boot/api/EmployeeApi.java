package com.example.timeSheets.boot.api;

import com.example.timeSheets.boot.model.Employee;
import com.example.timeSheets.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String save(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee saved with success";
    }

    @GetMapping("/v2")
    public Page<Employee> findByNamev2(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2Employee(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/v2/get-list")
    public Page<Employee> findByNv2Employee(@RequestParam String searchTerm,
                                            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNv2Employee(pageNumber, pageSize, searchTerm);
    }

//    @GetMapping("/v2/supervisor")
//    public Page<Employee> findByNamev2Supervidor(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
//                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
//        return service.findByNamev2Supervidor(pageNumber, pageSize, searchTerm);
//    }
    @PutMapping
    public String update(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee updated with success";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return "Employee " + employeeId + " Was deleted";
    }
}
