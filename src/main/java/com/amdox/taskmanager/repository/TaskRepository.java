package com.amdox.taskmanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdox.taskmanager.entity.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

	List<Task> findByAssignedTo(String email);
}
