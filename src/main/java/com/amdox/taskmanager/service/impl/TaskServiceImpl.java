package com.amdox.taskmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdox.taskmanager.constant.TaskStatus;
import com.amdox.taskmanager.dto.TaskRequest;
import com.amdox.taskmanager.entity.Task;
import com.amdox.taskmanager.repository.TaskRepository;
import com.amdox.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createTask(TaskRequest request) {

		Task task = new Task();
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setAssignedTo(request.getAssignedTo());
		task.setDueDate(request.getDueDate());
		task.setPriority(request.getPriority());

		return this.taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return this.taskRepository.findAll();
	}

	@Override
	public List<Task> getTasksByUser(String email) {
		return this.taskRepository.findByAssignedTo(email);
	}

	@Override
	public Task updateTaskStatus(String taskId, TaskStatus status) {
		Optional<Task> taskOpt = this.taskRepository.findById(taskId);
		if (taskOpt.isEmpty()) {
			throw new RuntimeException("Task not found.");
		}
		Task existingTask = taskOpt.get();
		existingTask.setStatus(status);
		return this.taskRepository.save(existingTask);

	}
}
