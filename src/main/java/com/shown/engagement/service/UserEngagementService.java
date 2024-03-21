package com.shown.engagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import com.shown.engagement.model.EngagementParameter;
import com.shown.engagement.repository.UserEngagementRepository;

@Service
public class UserEngagementService {

	@Autowired 
	UserEngagementRepository repository;
	
	private int MAX_RESULTS = 20;
	
	public EngagementParameter incrementLikes (String postId) {
		EngagementParameter userEngagement = repository.findById(postId).orElseGet(()-> new EngagementParameter(postId, 0, 0, 0));
		if(userEngagement.getLikes() == 0) {
			return repository.save(userEngagement);
		}
		long likes = userEngagement.getLikes() + 1;
		userEngagement.setLikes(likes);
		return repository.save(userEngagement);
	}
	
	public EngagementParameter decrementLikes(String postId) {
		EngagementParameter userEngagement = repository.findById(postId).orElseGet(()-> new EngagementParameter(postId, 0, 0, 0));
		if(userEngagement.getLikes() == 0) {
			return repository.save(userEngagement);
		}
		long likes = userEngagement.getLikes() - 1;
		userEngagement.setLikes(likes);
		return repository.save(userEngagement);
	}
	
	public EngagementParameter incrementClicks (String postId) {
		EngagementParameter userEngagement = repository.findById(postId).orElseGet(()-> new EngagementParameter(postId, 0, 0, 0));
		long clicks = userEngagement.getClicks() + 1;
		userEngagement.setClicks(clicks);
		return repository.save(userEngagement);
	}
	
	public EngagementParameter getUserEngagementById(String postId) {
		Optional<EngagementParameter> engagement = repository.findById(postId);
		if(engagement.isEmpty()) {
			return repository.save(new EngagementParameter(postId, 0, 0, 0));
		} 
		return engagement.get();
	}
	
	public List<EngagementParameter> getPopularBlogs() {
		return repository.findByOrderByLikesDesc(Limit.of(MAX_RESULTS));
	}
}
 