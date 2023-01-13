package com.example.timeSheets.boot.api;

import com.example.timeSheets.boot.model.TimeSheet;
import com.example.timeSheets.boot.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("timesheet")
public class TimeSheetApi {

    @Autowired
    private TimeSheetService service;

    @PostMapping
    public String save(@RequestBody TimeSheet timeSheet) {
        service.save(timeSheet);
        return "TimeSheet saved with success";
    }

    @GetMapping("/{timeSheetId}")
    public Optional<TimeSheet> findtimeSheet(@PathVariable Long timeSheetId) {
        return service.findTimeSheet(timeSheetId);
    }

    @GetMapping
    public Page<TimeSheet> findAllByOrderByIdDesc(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return service.findAllByOrderByIdDesc(pageNumber, pageSize);
    }

    @GetMapping("v2")
    public Page<TimeSheet> findByEmployeeIdOrderByIdDesc(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                            @RequestParam Long employee) {
        return service.findByEmployeeIdOrderByIdDesc(pageNumber, pageSize,employee);
    }

    @PutMapping
    public String update(@RequestBody TimeSheet timeSheet) {
        service.save(timeSheet);
        return "Time sheet with success";
    }

    @DeleteMapping("/{timeSheetId}")
    public String deletetimeSheet(@PathVariable Long timeSheetId) {
        service.deleteById(timeSheetId);
        return "Time sheet " + timeSheetId + " Was deleted";
    }
}
