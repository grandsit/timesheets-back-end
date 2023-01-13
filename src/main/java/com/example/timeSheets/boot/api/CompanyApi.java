//package com.example.controlehoras.boot.api;
//
//import com.example.controlehoras.boot.model.Company;
//import com.example.controlehoras.boot.service.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("company")
//public class CompanyApi {
//
//    @Autowired
//    private CompanyService service;
//
//    @PostMapping
//    public String save(@RequestBody Company company) {
//        service.save(company);
//        return "Company saved with success";
//    }
//
//    @GetMapping("/{companyId}")
//    public Optional<Company> findCompany(@PathVariable Long companyId) {
//        return service.findCompany(companyId);
//    }
//
//    @GetMapping
//    public ResponseEntity findByName(@RequestParam String searchTerm) {
//        return ResponseEntity.ok(service.findByName(searchTerm));
//    }
//
//    @GetMapping("/v2")
//    public Page<Company> findByNamev2(@RequestParam String searchTerm,
//                                      @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
//                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
//        return service.findByNamev2(pageNumber, pageSize, searchTerm);
//    }
//
//    @PutMapping
//    public String update(@RequestBody Company company) {
//        service.save(company);
//        return "Company updated with success";
//    }
//
//    @DeleteMapping("/{companyId}")
//    public String deleteCompany(@PathVariable Long companyId) {
//        if (service.searchRelation(companyId)){
//            throw new RuntimeException("Empresa já está vinculada a um cliente");
//        }
//        service.deleteById(companyId);
//        return "Company " + companyId + " Was deleted";
//    }
//}
