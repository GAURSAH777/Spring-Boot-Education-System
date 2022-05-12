package com.cg.services;

import java.util.List;

import com.cg.entities.Feedback;

public interface FeedbackService {

	public List<Feedback> getAllFeedbacks();

	public Feedback saveFeedback(Feedback feedback);
}
