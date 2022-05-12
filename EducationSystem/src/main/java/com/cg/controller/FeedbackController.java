package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entities.Feedback;
import com.cg.services.FeedbackService;

@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackservice;

	@GetMapping("/all")
	public List<Feedback> fetchAllFeedbacks() {

		List<Feedback> feedbacks = feedbackservice.getAllFeedbacks();
		return feedbacks;
	}

	@PostMapping("/save")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback) {

		Feedback newFeedback = feedbackservice.saveFeedback(feedback);
		ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
		return responseEntity;
	}

}
