package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.StudyMaterial;
import com.cg.entities.Trainer;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	transient private TrainerRepository trainerRepo;

	@Override
	public List<Trainer> getAllTrainers() {

		List<Trainer> trainers = trainerRepo.findAll();

		return trainers;
	}

	@Override
	public Trainer saveTrainer(Trainer trainer) {

		Trainer savedTrainer = trainerRepo.save(trainer);

		return savedTrainer;
	}

	@Override
	public Trainer getTrainerById(int trainerId) {

		Optional<Trainer> optionalTrainer = trainerRepo.findById(trainerId);

		if (optionalTrainer == null) {
			throw new ResourceNotFoundException("Product not exising with id: " + trainerId);
		}

		Trainer trainer = optionalTrainer.get();

		return trainer;
	}

	@Override
	public void deleteTrainer(int trainerId) {

		Optional<Trainer> optionalTrainer = trainerRepo.findById(trainerId);

		if (optionalTrainer == null) {
			throw new ResourceNotFoundException("Product not exising with id: " + trainerId);
		}

		Trainer trainer = optionalTrainer.get();

		trainerRepo.delete(trainer);

	}

	@Override
	public Trainer updateTrainer(Trainer trainer) {

		Optional<Trainer> optionalTrainer = trainerRepo.findById(trainer.getTrainerId());

		if (optionalTrainer == null) {
			throw new ResourceNotFoundException("Product not exising with id: " + trainer.getTrainerId());
		}

		Trainer updatedTrainer = trainerRepo.save(trainer);

		return updatedTrainer;
	}

}
