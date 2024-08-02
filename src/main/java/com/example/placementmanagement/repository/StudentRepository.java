package com.example.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.placementmanagement.model.Student;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
