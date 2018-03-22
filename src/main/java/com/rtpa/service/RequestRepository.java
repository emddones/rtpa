package com.rtpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rtpa.service.model.Request;

@Repository
@Transactional(readOnly=false)
public interface RequestRepository extends JpaRepository<Request, String> {

}
