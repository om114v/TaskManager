package com.amdox.taskmanager.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.amdox.taskmanager.bo.BaseEntity;
import com.amdox.taskmanager.constant.TaskPriority;
import com.amdox.taskmanager.constant.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task extends BaseEntity {

	private String title;

	private String description;

	private String assignedTo;

	private Date dueDate;

	private TaskStatus status = TaskStatus.OPEN;

	private TaskPriority priority;

}
