package com.amdox.taskmanager.service;

import java.util.List;

import com.amdox.taskmanager.constant.TaskStatus;
import com.amdox.taskmanager.dto.TaskRequest;
import com.amdox.taskmanager.entity.Task;

public interface TaskService {

	Task createTask(TaskRequest request);

	List<Task> getAllTasks();

	List<Task> getTasksByUser(String email);

	Task updateTaskStatus(String taskId, TaskStatus status);

}
