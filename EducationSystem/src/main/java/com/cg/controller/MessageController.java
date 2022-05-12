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

import com.cg.entities.Message;
import com.cg.services.MessageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/all")
	public List<Message> fetchAllMessages() {

		List<Message> messages = messageService.getAllMessages();
		return messages;
	}

	@PostMapping("/save")
	public ResponseEntity<Message> addMessage(@Valid @RequestBody Message message) {

		Message newMessage = messageService.saveMessage(message);
		ResponseEntity<Message> responseEntity = new ResponseEntity<>(newMessage, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchMessageById(@PathVariable("id") int messageId) {

		ResponseEntity<?> responseEntity = null;
		Message message = messageService.getMessageById(messageId);
		responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMessageById(@PathVariable("id") int messageId) {

		ResponseEntity<String> responseEntity = null;
		messageService.deleteMessageById(messageId);
		responseEntity = new ResponseEntity<>("Message deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateMessage(@RequestBody Message message) {

		ResponseEntity<Object> responseEntity = null;
		Message updatedMessage = messageService.updateMessage(message);
		responseEntity = new ResponseEntity<>(updatedMessage, HttpStatus.OK);
		return responseEntity;
	}

}
