package com.amdox.taskmanager.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.amdox.taskmanager.bo.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile extends BaseEntity {

	private String name;

	private String email;

	private String department;

	private String designation;

	private String organisation;

	private Boolean isActive = true;

}
