package com.example.placementmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.placementmanagement.model.Company;
import com.example.placementmanagement.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		return companyService.getCompanyById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Company createCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails){
		return companyService.getCompanyById(id)
				.map(company -> {
					company.setName(companyDetails.getName());
					company.setLocation(companyDetails.getLocation());
					company.setIndustry(companyDetails.getIndustry());
					return ResponseEntity.ok(companyService.saveCompany(company));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id){
		return companyService.getCompanyById(id)
				.map(company -> {
					companyService.deleteCompany(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}	
}
