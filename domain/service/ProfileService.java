package com.dh.moneymanager.domain.service;

import com.dh.moneymanager.application.dto.ProfileDto;
import com.dh.moneymanager.domain.entity.ProfileEntity;
import com.dh.moneymanager.external.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.SimpleTimeZone;
import java.util.UUID;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final EmailService emailService;
    public ProfileService(ProfileRepository profileRepository,EmailService emailService){
        this.profileRepository=profileRepository;
        this.emailService=emailService;
    }
    public ProfileDto registerProfile(ProfileDto profileDto){
        ProfileEntity profileEntity=toEntity(profileDto);
        profileEntity.setActivationToken(UUID.randomUUID().toString());
        profileEntity =profileRepository.save(profileEntity);

        //send activation email
        String activationLink ="http://localhost:3010/profile/activate?token=" + profileEntity.getActivationToken();
        String subject= "Activate your Email for Money Manager";
        String body= "Click on the following link to activate your account: " + activationLink;
        emailService.sendEmail(profileEntity.getEmail(),subject,body);

        return toDto(profileEntity);

    }

    public boolean activateProfile(String activationToken){
        return profileRepository.findByActivationToken(activationToken)
                .map(profile ->{
                    profile.setActive(true);
                    profileRepository.save(profile);
                    return true;
                })
                .orElse(false);
    }

    public ProfileEntity toEntity(ProfileDto profileDto){
        return ProfileEntity.builder()
                .id(profileDto.getId())
                .fullName(profileDto.getFullName())
                .email(profileDto.getEmail())
                .password(profileDto.getPassword())
                .profileImageUrl(profileDto.getProfileImageUrl())
                .createdAt(profileDto.getCreatedAt())
                .updatedAt(profileDto.getUpdatedAt())
                .build();
    }

    public ProfileDto toDto(ProfileEntity profileEntity){
        return ProfileDto.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImageUrl(profileEntity.getProfileImageUrl())
                .createdAt(profileEntity.getCreatedAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }
}
