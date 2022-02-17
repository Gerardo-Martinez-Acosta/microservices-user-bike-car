package com.tutorial.bikeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	
	@Autowired
	BikeService bikeService;
	
	@GetMapping
	public ResponseEntity<List<Bike>> getAll(){
		List<Bike> Bikes = bikeService.getAll();
		if (Bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(Bikes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getById(@PathVariable("id") int id){
		Bike bike = bikeService.getCarById(id);
		if (bike==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bike);
	}
	
	@PostMapping()
	public ResponseEntity<Bike> save(@RequestBody Bike bike){
		Bike bikeNew = bikeService.save(bike);
		return ResponseEntity.ok(bikeNew);
	}
	
	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId){
		List<Bike> bikes = bikeService.byUserId(userId);
	
		return ResponseEntity.ok(bikes);
	}
	
}
