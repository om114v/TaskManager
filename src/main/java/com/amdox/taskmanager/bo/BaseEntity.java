package com.amdox.taskmanager.bo;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity {

	@Id
	private String id;

	@CreatedDate
	private Date createdAt;

	@LastModifiedDate
	private Date updatedAt;
}
