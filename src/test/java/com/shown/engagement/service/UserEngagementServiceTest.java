package com.shown.engagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.shown.engagement.model.EngagementParameter;
import com.shown.engagement.repository.UserEngagementRepository;

@SpringBootTest
@Transactional
class UserEngagementServiceTest {
	
	@Autowired
	private UserEngagementRepository repository;
	
	@Autowired
	private UserEngagementService service;
	
	@BeforeEach 
	public void setUp() {
		//repository.save(new UserEngagement("65fc72d9d7269a7625591c2a", 123, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2b", 132, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2c", 8261, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2d", 322, 13, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2e", 877, 1809, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2f", 123, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2g", 12, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2h", 976, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2i", 140, 1987, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2j", 29, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2k", 876, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2l", 922, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2m", 11, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2n", 120, 987, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2o", 0, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2p", 1293, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2q", 987, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2r", 9876, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2s", 675, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2t", 92761, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2u", 856, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2w", 99, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2x", 927, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2y", 98765, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c2z", 45, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c3a", 678, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c3b", 989, 0, 0));
		repository.save(new EngagementParameter("65fc72d9d7269a7625591c3c", 989, 0, 0));
	}

	@Test
	void testIncrementLikes() {
		Optional<EngagementParameter> engagement = repository.findById("65fc72d9d7269a7625591c2p");
		assertTrue(engagement.isPresent());
		service.incrementLikes("65fc72d9d7269a7625591c2p");
		engagement = repository.findById("65fc72d9d7269a7625591c2p");
		assertTrue(engagement.isPresent());
		assertEquals(1294, engagement.get().getLikes());
	}

	@Test
	void testDecrementLikes() {
		Optional<EngagementParameter> engagement = repository.findById("65fc72d9d7269a7625591c2p");
		assertTrue(engagement.isPresent());
		service.decrementLikes("65fc72d9d7269a7625591c2p");
		engagement = repository.findById("65fc72d9d7269a7625591c2p");
		assertTrue(engagement.isPresent());
		assertEquals(1292, engagement.get().getLikes());
	}

	@Test
	void testIncrementClicks() {
		Optional<EngagementParameter> engagement = repository.findById("65fc72d9d7269a7625591c2n");
		assertTrue(engagement.isPresent());
		service.incrementClicks("65fc72d9d7269a7625591c2n");
		engagement = repository.findById("65fc72d9d7269a7625591c2n");
		assertTrue(engagement.isPresent());
		assertEquals(988, engagement.get().getClicks());
	}
	
	@Test
	void testIncrementLikesWhenNoEntryExists() {
		Optional<EngagementParameter> engagement = repository.findById("65fc72d9d7269a7625591c2a");
		assertTrue(engagement.isEmpty());
		service.incrementLikes("65fc72d9d7269a7625591c2a");
		engagement = repository.findById("65fc72d9d7269a7625591c2a");
		assertTrue(engagement.isPresent());
		assertEquals(1, engagement.get().getLikes());
	}

	@Test
	void testIncrementClicksWhenNoEntryExists() {
		Optional<EngagementParameter> engagement = repository.findById("65fc72d9d7269a7625591c2a");
		assertTrue(engagement.isEmpty());
		service.incrementClicks("65fc72d9d7269a7625591c2a");
		engagement = repository.findById("65fc72d9d7269a7625591c2a");
		assertTrue(engagement.isPresent());
		assertEquals(1, engagement.get().getClicks());
	}
	
	@Test
	void testGetUserEngagementById() {
		EngagementParameter engagement = service.getUserEngagementById("65fc72d9d7269a7625591c2n");
		assertEquals(120,engagement.getLikes());
	}

	@Test
	void testGetPopularBlogs() {
		Pageable paging  = PageRequest.of(0, 2);
		List<EngagementParameter> popular = service.getPopularBlogs(paging);
		assertEquals(2, popular.size());
		assertEquals("65fc72d9d7269a7625591c2y", popular.get(0).getPostId());
		paging  = PageRequest.of(0, 5);
		popular = service.getPopularBlogs(paging);
		assertEquals(5, popular.size());
		assertEquals("65fc72d9d7269a7625591c2y", popular.get(0).getPostId());
		paging  = PageRequest.of(0, 20);
		popular = service.getPopularBlogs(paging);
		assertEquals(20, popular.size());
		assertEquals("65fc72d9d7269a7625591c2y", popular.get(0).getPostId());
	}

}
