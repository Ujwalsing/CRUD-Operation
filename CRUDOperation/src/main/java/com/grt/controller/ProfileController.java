package com.grt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grt.Service.ProfileService;
import com.grt.model.Profile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {
	
	private ProfileService profileService;
	
	
	@PutMapping()
	public ResponseEntity<Profile> udpateProfileById(Profile profile){
		return new ResponseEntity<Profile>(profileService.updateProfile(profile),HttpStatus.CREATED);
		
	}
	
}
