package com.amdox.taskmanager.dto;

import java.util.Date;

import com.amdox.taskmanager.constant.TaskPriority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

	private String title;

	private String description;

	private String assignedTo;

	private Date dueDate;

	private TaskPriority priority;
}
