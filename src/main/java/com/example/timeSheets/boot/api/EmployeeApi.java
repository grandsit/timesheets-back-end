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
    public Page<Employee> findByEmployee(@RequestParam String searchTerm,
                                       @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByEmployee(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/v2/get-list")
    public Page<Employee> getListEmployee(@RequestParam String searchTerm,
                                            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.getListEmployee(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/v2/supervisor")
    public Page<Employee> findBySupervidor(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                           @RequestParam String searchTerm) {
        return service.findBySupervidor(pageNumber, pageSize, searchTerm);
    }
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return "Employee " + employeeId + " Was deleted";
    }
}
