package com.amdox.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdox.taskmanager.constant.TaskStatus;
import com.amdox.taskmanager.dto.TaskRequest;
import com.amdox.taskmanager.entity.Task;
import com.amdox.taskmanager.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("")
	public ResponseEntity<Task> createTask(@RequestBody TaskRequest request) {
		Task task = this.taskService.createTask(request);
		return new ResponseEntity<Task>(task, HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> tasks = this.taskService.getAllTasks();
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	@GetMapping("/{email}")
	public ResponseEntity<List<Task>> getTasksByUser(@PathVariable String email) {
		List<Task> tasks = this.taskService.getTasksByUser(email);
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	@PatchMapping("/updateStatus")
	public ResponseEntity<Task> updateStatus(@RequestParam String id, @RequestParam TaskStatus status) {
		Task task = this.taskService.updateTaskStatus(id, status);
		return new ResponseEntity<Task>(task, HttpStatus.CREATED);
	}
}
