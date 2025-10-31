package com.amdox.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdox.taskmanager.entity.Profile;
import com.amdox.taskmanager.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@PostMapping("")
	public Profile createProfile(@RequestBody Profile request) {
		return this.profileService.createProfile(request);
	}

	@GetMapping("")
	public List<Profile> getAllProfiles() {
		return this.profileService.getAllProfiles();
	}

	@GetMapping("/{email}")
	public Profile getProfileByEmail(@PathVariable String email) {
		return this.profileService.getProfileByEmail(email);
	}

	@PutMapping
	public Profile updateProfile(@RequestBody Profile request) {
		return this.profileService.updateProfile(request);
	}
}
