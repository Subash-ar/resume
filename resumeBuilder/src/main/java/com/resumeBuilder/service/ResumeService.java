package com.resumeBuilder.service;


import java.util.List;

import com.resumeBuilder.entity.ResumeEntity;

public interface ResumeService {
	
	ResumeEntity createUserProfile(ResumeEntity userProfile);
	ResumeEntity updateUserProfile(Long id, ResumeEntity userProfile);
	ResumeEntity getUserProfileById(Long id);
	List<ResumeEntity> getAllUserProfiles();
	void deleteUserProfile(Long id);

}
