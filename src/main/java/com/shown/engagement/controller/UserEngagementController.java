package com.shown.engagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shown.engagement.model.EngagementParameter;
import com.shown.engagement.service.UserEngagementService;

@RestController
public class UserEngagementController {
	@Autowired
	private UserEngagementService service;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/engagement")
	public String greeting() {
		return "Hello world";
	}
	
	@GetMapping("/engagement/getUserEngagementForPost")
	public EngagementParameter getUserEngagementForPost(@RequestParam(value = "id") String id) {
		try {
			return service.getUserEngagementById(id);
		} catch(Exception e) {
			logger.error("Error finding the blog", e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User engagement for blog %s not found", id));
		}
	}
	
	@GetMapping("/engagement/getPopularBlogs")
	public List<EngagementParameter> getPopularBlogs() {
		try {
			return service.getPopularBlogs();
		} catch(Exception e) {
			logger.error("Error finding the blogs", e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No blogs could be found"));
		}
	}
	
	@ResponseStatus(HttpStatus.OK) 
	@PostMapping("/engagement/incrementLikes")
	public EngagementParameter incrementLikes(@RequestParam(value = "id") String id) {
		try {
			return service.incrementLikes(id);
		} catch (DataIntegrityViolationException e) {
			logger.error("Can not update the like count", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@ResponseStatus(HttpStatus.OK) 
	@PostMapping("/engagement/decrementLikes")
	public EngagementParameter decrementLikes(@RequestParam(value = "id") String id) {
		try {
			return service.decrementLikes(id);
		} catch (DataIntegrityViolationException e) {
			logger.error("Can not update the like count", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@ResponseStatus(HttpStatus.OK) 
	@PostMapping("/engagement/incrementClicks")
	public EngagementParameter incrementClicks(@RequestParam(value = "id") String id) {
		try {
			return service.incrementClicks(id);
		} catch (DataIntegrityViolationException e) {
			logger.error("Can not update the like count", e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
