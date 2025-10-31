package com.amdox.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amdox.taskmanager.entity.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {
	Optional<Profile> findByEmail(String email);
}
