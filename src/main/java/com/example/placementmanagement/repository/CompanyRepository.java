package com.example.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.placementmanagement.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

}
