package com.cg.services;

import java.util.List;

import com.cg.entities.Message;

public interface MessageService {

	public Message saveMessage(Message message);

	public Message getMessageById(int messageId);

	public List<Message> getAllMessages();

	public Message updateMessage(Message message);

	public void deleteMessageById(int messageId);
}
