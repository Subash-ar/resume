package com.resumeBuilder.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumeBuilder.entity.ResumeEntity;
import com.resumeBuilder.repository.ResumeRepo;
import com.resumeBuilder.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
	private ResumeRepo resumerepo;

	@Override
	public ResumeEntity createUserProfile(ResumeEntity userProfile) {
		// TODO Auto-generated method stub
		return resumerepo.save(userProfile);
	}

	@Override
	public ResumeEntity updateUserProfile(Long id, ResumeEntity userProfile) {
		// TODO Auto-generated method stub
		Optional<ResumeEntity> optionalUserProfile = resumerepo.findById(id);
        if (optionalUserProfile.isPresent()) {
        	ResumeEntity existingUserProfile = optionalUserProfile.get();
            existingUserProfile.setName(userProfile.getName());
            existingUserProfile.setRole(userProfile.getRole());
            existingUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
            existingUserProfile.setEmailId(userProfile.getEmailId());
            existingUserProfile.setLocation(userProfile.getLocation());
            existingUserProfile.setObjective(userProfile.getObjective());
            existingUserProfile.setProfileOverview(userProfile.getProfileOverview());
            existingUserProfile.setSkills(userProfile.getSkills());
            existingUserProfile.setSocialLinks(userProfile.getSocialLinks());
            existingUserProfile.setEmploymentHistory(userProfile.getEmploymentHistory());
            existingUserProfile.setHobbies(userProfile.getHobbies());
            existingUserProfile.setAdditionalFields(userProfile.getAdditionalFields());
            return resumerepo.save(existingUserProfile);
        } else {
            return null;
        }	}

	@Override
	public ResumeEntity getUserProfileById(Long id) {
		// TODO Auto-generated method stub
		return resumerepo.findById(id).orElse(null);
	}

	@Override
	public List<ResumeEntity> getAllUserProfiles() {
		// TODO Auto-generated method stub
		Iterable<ResumeEntity> iterable = resumerepo.findAll();
		List<ResumeEntity> list = new ArrayList<>();
		iterable.forEach(list::add);
        return list;	}

	@Override
	public void deleteUserProfile(Long id) {
		// TODO Auto-generated method stub
		resumerepo.deleteById(id);

		
	}

	


}
