package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Message;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repositories.MessageRepository;

@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	private MessageRepository messageRepo; // autowiring repository interface

	@Override
	public Message saveMessage(Message message) {
		Message savedMessage = messageRepo.save(message);
		return savedMessage;
	}

	@Override
	public Message getMessageById(int messageId) {
		Optional<Message> optionalMessage = messageRepo.findById(messageId);
		if (optionalMessage == null)
			throw new ResourceNotFoundException("Message Not found with id : " + messageId);
		Message message = optionalMessage.get();
		return message;
	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> messages = messageRepo.findAll();
		return messages;
	}

	@Override
	public Message updateMessage(Message message) {
		Message updatedMessage = getMessageById(message.getMessageId());
		updatedMessage = messageRepo.save(message);
		return updatedMessage;
	}

	@Override
	public void deleteMessageById(int messageId) {
		Message message = getMessageById(messageId);
		messageRepo.delete(message);
	}

}
