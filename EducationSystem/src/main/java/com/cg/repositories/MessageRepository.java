package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
