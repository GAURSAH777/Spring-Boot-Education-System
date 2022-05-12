package com.cg.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Trainer;
import com.cg.services.TrainerService;

@CrossOrigin("*")
@RestController

@RequestMapping("/trainers")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	@GetMapping("/all")
	public List<Trainer> fetchAllTrainers() {

		List<Trainer> trainers = trainerService.getAllTrainers();
		return trainers;
	}

	@PostMapping("/save")
	public ResponseEntity<Trainer> addTrainer(@Valid @RequestBody Trainer trainer) {

		Trainer newTrainer = trainerService.saveTrainer(trainer);
		ResponseEntity<Trainer> responseEntity = new ResponseEntity<>(newTrainer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchTrainerById(@PathVariable("id") int trainerId) {

		ResponseEntity<?> responseEntity = null;
		Trainer trainer = trainerService.getTrainerById(trainerId);
		responseEntity = new ResponseEntity<>(trainer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTrainerById(@PathVariable("id") int trainerId) {

		ResponseEntity<String> responseEntity = null;
		trainerService.deleteTrainer(trainerId);
		responseEntity = new ResponseEntity<>("Trainer deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateTrainer(@RequestBody Trainer trainer) {

		ResponseEntity<Object> responseEntity = null;
		Trainer updatedTrainer = trainerService.updateTrainer(trainer);
		responseEntity = new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
		return responseEntity;
	}

}
