package com.dh.moneymanager.application.dto;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class ProfileDto {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfileDto(long id, String fullName, String email, String profileImageUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public static class ProfileDtoBuilder{
        private long id;
        private String fullName;
        private String email;
        private String password;
        private String profileImageUrl;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public ProfileDtoBuilder id(Long id){this.id=id; return this;}
        public ProfileDtoBuilder fullName(String fullName){this.fullName=fullName; return this;}
        public ProfileDtoBuilder email(String email){this.email=email; return this;}
        public ProfileDtoBuilder password(String password){this.password=password; return this;}
        public ProfileDtoBuilder createdAt (LocalDateTime createdAt){this.createdAt=createdAt; return this;}
        public ProfileDtoBuilder updatedAt (LocalDateTime updatedAt){this.updatedAt=updatedAt; return  this;}
        public ProfileDtoBuilder profileImageUrl(String profileImageUrl){this.profileImageUrl=profileImageUrl; return this;}

        public ProfileDto build(){
            return new ProfileDto(id,fullName,email,profileImageUrl,createdAt,updatedAt);
        }


    }
    public static ProfileDtoBuilder builder(){
        return new ProfileDtoBuilder();
    }


}
