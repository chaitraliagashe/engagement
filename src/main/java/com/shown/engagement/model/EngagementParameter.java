package com.shown.engagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "engagement_parameter")
public class EngagementParameter {
	@Id
	private String postId;
	
	private long likes;
	
	private long clicks;
	
	private long dislikes;
	
	public EngagementParameter() {
	}

	public EngagementParameter(String postId, long likes, long clicks, long dislikes) {
		this.postId = postId;
		this.likes = likes;
		this.clicks = clicks;
		this.dislikes = dislikes;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getClicks() {
		return clicks;
	}

	public void setClicks(long clicks) {
		this.clicks = clicks;
	}

	public long getDislikes() {
		return dislikes;
	}

	public void setDislikes(long dislikes) {
		this.dislikes = dislikes;
	}

}
