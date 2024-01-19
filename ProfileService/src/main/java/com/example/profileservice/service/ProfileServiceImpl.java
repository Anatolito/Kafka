package com.example.profileservice.service;


import com.example.profileservice.model.Profile;
import com.example.profileservice.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements SaveEntity<Profile> {
    private final ProfileRepository profileRepository;

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

}
