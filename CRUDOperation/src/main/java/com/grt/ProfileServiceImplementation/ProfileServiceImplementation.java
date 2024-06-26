package com.grt.ProfileServiceImplementation;

import org.springframework.stereotype.Service;

import com.grt.Service.ProfileService;
import com.grt.model.Profile;
import com.grt.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation implements ProfileService {

	private ProfileRepository profileRepository;

	@Override
	public Profile updateProfile(Profile profile) {
		Profile profileById= profileRepository.getById(profile.getId());
		return profileRepository.save(profileById);
	}


}
