package com.resumeBuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumeBuilder.entity.ResumeEntity;
import com.resumeBuilder.service.ResumeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
	@Autowired
	private ResumeService resumeservice;
	
	@PostMapping
	public ResponseEntity<ResumeEntity> createResumeEntity(@RequestBody ResumeEntity resumeentity){
		   ResumeEntity createdUserProfile = resumeservice.createUserProfile(resumeentity);
	        return ResponseEntity.ok(createdUserProfile);
	}

	 @PutMapping("/{id}")
	    public ResponseEntity<ResumeEntity> updateUserProfile(@PathVariable Long id, @RequestBody ResumeEntity userProfile) {
		 ResumeEntity updatedUserProfile = resumeservice.updateUserProfile(id, userProfile);
	        if (updatedUserProfile == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(updatedUserProfile);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<ResumeEntity> getUserProfileById(@PathVariable Long id) {
		 ResumeEntity userProfile = resumeservice.getUserProfileById(id);
	        if (userProfile == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(userProfile);
	    }
	 
	 @GetMapping
	    public ResponseEntity<List<ResumeEntity>> getAllUserProfiles() {
	        List<ResumeEntity> userProfiles = resumeservice.getAllUserProfiles();
	        return ResponseEntity.ok(userProfiles);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
	    	resumeservice.deleteUserProfile(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
