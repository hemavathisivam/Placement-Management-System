package com.example.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.placementmanagement.model.Placement;

public interface PlacementRepository extends JpaRepository<Placement,Long>{

}
