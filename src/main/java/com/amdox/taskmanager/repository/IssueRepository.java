package com.amdox.taskmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdox.taskmanager.constant.IssueStatus;
import com.amdox.taskmanager.entity.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {
	Optional<Issue> findByKey(String key);

	List<Issue> findByAssignedEmail(String assignedEmail);

	List<Issue> findByEpicId(String epicId);

	List<Issue> findBySprintId(String sprintId);

	List<Issue> findByStatus(IssueStatus status);
}
