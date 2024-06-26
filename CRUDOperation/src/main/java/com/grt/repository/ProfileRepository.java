package com.grt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grt.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
