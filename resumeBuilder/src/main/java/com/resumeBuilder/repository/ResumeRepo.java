package com.resumeBuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.resumeBuilder.entity.ResumeEntity;

public interface ResumeRepo extends CrudRepository<ResumeEntity, Long> {

}
