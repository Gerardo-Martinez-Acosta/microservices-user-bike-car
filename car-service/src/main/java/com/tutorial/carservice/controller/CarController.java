package com.tutorial.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService CarService;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAll(){
		List<Car> Cars = CarService.getAll();
		if (Cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(Cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id){
		Car Car = CarService.getCarById(id);
		if (Car==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(Car);
	}
	
	@PostMapping()
	public ResponseEntity<Car> save(@RequestBody Car car){
		Car CarNew = CarService.save(car);
		return ResponseEntity.ok(CarNew);
	}
	
	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId){
		List<Car> cars = CarService.byUserId(userId);
		 
		return ResponseEntity.ok(cars);
	}
	
}
