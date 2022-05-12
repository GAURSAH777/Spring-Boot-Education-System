package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Feedback;

import com.cg.repositories.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	transient private FeedbackRepository feedbackRepo;

	@Override
	public List<Feedback> getAllFeedbacks() {

		List<Feedback> feedbacks = feedbackRepo.findAll();

		return feedbacks;
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {

		Feedback savedFeedback = feedbackRepo.save(feedback);

		return savedFeedback;
	}

}
