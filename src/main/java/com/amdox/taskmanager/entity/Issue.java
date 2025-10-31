package com.amdox.taskmanager.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.amdox.taskmanager.bo.BaseEntity;
import com.amdox.taskmanager.constant.IssuePriority;
import com.amdox.taskmanager.constant.IssueStatus;
import com.amdox.taskmanager.constant.IssueType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Issue extends BaseEntity {
	private String key;
	private String title;
	private String description;
	private IssueType type;
	private IssuePriority priority;
	private IssueStatus status;
	private String assignedEmail;
	private String reporterEmail;
	private String epicId;
	private String sprintId;
	private Date dueDate;
}
