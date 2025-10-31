package com.amdox.taskmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdox.taskmanager.entity.Profile;
import com.amdox.taskmanager.repository.ProfileRepository;
import com.amdox.taskmanager.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile createProfile(Profile request) {

		if (this.profileRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("Profile already exists for this email: " + request.getEmail());
		}

		Profile profile = new Profile();
		profile.setName(request.getName());
		profile.setEmail(request.getEmail());
		profile.setDepartment(request.getDepartment());
		profile.setDesignation(request.getDesignation());
		profile.setOrganisation(request.getOrganisation());

		return this.profileRepository.save(profile);
	}

	@Override
	public List<Profile> getAllProfiles() {
		return this.profileRepository.findAll();
	}

	@Override
	public Profile getProfileByEmail(String email) {
		Optional<Profile> profileOpt = this.profileRepository.findByEmail(email);
		if (profileOpt.isEmpty()) {
			throw new RuntimeException("Profile not found for this email: " + email);
		}
		return profileOpt.get();
	}

	@Override
	public Profile updateProfile(Profile request) {
		Optional<Profile> profileOpt = this.profileRepository.findById(request.getId());
		if (profileOpt.isEmpty()) {
			throw new RuntimeException("Profile not found.");
		}

		if (!request.getEmail().equals(profileOpt.get().getEmail())) {
			throw new RuntimeException("Email can't be changed while updating profile.");
		}

		return this.profileRepository.save(request);
	}

}
