package com.cg.services;

import java.util.List;

import com.cg.entities.Trainer;

public interface TrainerService {

	public List<Trainer> getAllTrainers();

	public Trainer saveTrainer(Trainer trainer);

	public Trainer getTrainerById(int trainerId);

	public void deleteTrainer(int trainerId);

	public Trainer updateTrainer(Trainer trainer);

}
