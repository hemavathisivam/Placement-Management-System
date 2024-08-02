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

import com.example.placementmanagement.model.Placement;
import com.example.placementmanagement.service.PlacementService;

@RestController
@RequestMapping("/placements")
public class PlacementController {
	
	@Autowired
	private PlacementService placementService;
	
	@GetMapping
	public List<Placement> getAllPlacements(){
		return placementService.getAllPlacements();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Placement> getPlacementById(@PathVariable Long id){
		return placementService.getPlacementById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Placement createPlacement(@RequestBody Placement placement) {
		return placementService.savePlacement(placement);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Placement> updatePlacement(@PathVariable Long id, @RequestBody Placement placementDetails){
		return placementService.getPlacementById(id)
				.map(placement -> {
					placement.setStudentId(placementDetails.getStudentId());
					placement.setCompanyId(placementDetails.getCompanyId());
					placement.setDateOfPlacement(placementDetails.getDateOfPlacement());
					return ResponseEntity.ok(placementService.savePlacement(placement));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlacement(@PathVariable Long id){
		return placementService.getPlacementById(id)
				.map(placement -> {
					placementService.deletePlacement(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
