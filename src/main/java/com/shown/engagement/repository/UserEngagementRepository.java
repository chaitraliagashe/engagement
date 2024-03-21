package com.shown.engagement.repository;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;

import com.shown.engagement.model.EngagementParameter;

public interface UserEngagementRepository extends CrudRepository<EngagementParameter, String> {

	List<EngagementParameter> findByOrderByLikesDesc(Limit of);
	
}
