package com.rtpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rtpa.service.model.AttributeRemarks;

@Repository
@Transactional(readOnly=false)
public interface AttributeRemarksRepository extends CrudRepository<AttributeRemarks, Long>{
	
}
