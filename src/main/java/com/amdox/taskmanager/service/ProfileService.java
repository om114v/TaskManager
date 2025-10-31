package com.amdox.taskmanager.service;

import java.util.List;

import com.amdox.taskmanager.entity.Profile;

public interface ProfileService {

	Profile createProfile(Profile request);

	List<Profile> getAllProfiles();

	Profile getProfileByEmail(String email);

	Profile updateProfile(Profile request);

}
