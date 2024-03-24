package com.shown.engagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shown.engagement.EngagementApplication;
import com.shown.engagement.model.EngagementParameter;
import com.shown.engagement.repository.UserEngagementRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EngagementApplication.class)
@AutoConfigureMockMvc
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UserEngagementControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserEngagementRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		// repository.save(new UserEngagement("65fc72d9d7269a7625591c2a", 123, 0, 0));
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
	void testGetUserEngagementForPost() throws Exception {
		MvcResult result = mvc.perform(get("/engagement/getUserEngagementForPost").param("id", "65fc72d9d7269a7625591c2n")
				.contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "9H3hyCBR"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		String json = result.getResponse().getContentAsString();
		EngagementParameter parameter = new ObjectMapper().readValue(json, EngagementParameter.class);
		assertEquals("65fc72d9d7269a7625591c2n",parameter.getPostId());
	}

	@Test
	void testGetPopularBlogs() throws Exception {
		MvcResult result = mvc.perform(get("/engagement/getPopularBlogs")
							.contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "9H3hyCBR"))
							.andExpect(status().isOk())
							.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
						.andReturn();
		String json = result.getResponse().getContentAsString();
		EngagementParameter[] parameters = new ObjectMapper().readValue(json, EngagementParameter[].class);
		assertEquals("65fc72d9d7269a7625591c2y", parameters[0].getPostId());
	}

	@Test
	void testIncrementLikes() throws Exception {
		MvcResult result = mvc.perform(post("/engagement/incrementLikes").param("id", "65fc72d9d7269a7625591c2b")
				.contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "9H3hyCBR"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		String json = result.getResponse().getContentAsString();
		EngagementParameter parameter = new ObjectMapper().readValue(json, EngagementParameter.class);
		assertEquals(133, parameter.getLikes());
	}

	@Test
	void testDecrementLikes() throws Exception {
		MvcResult result = mvc.perform(post("/engagement/decrementLikes").param("id", "65fc72d9d7269a7625591c2b")
				.contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "9H3hyCBR"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		String json = result.getResponse().getContentAsString();
		EngagementParameter parameter = new ObjectMapper().readValue(json, EngagementParameter.class);
		assertEquals(131, parameter.getLikes());
	}

	@Test
	void testIncrementClicks() throws Exception {
		MvcResult result = mvc.perform(post("/engagement/incrementClicks").param("id", "65fc72d9d7269a7625591c2b")
				.contentType(MediaType.APPLICATION_JSON).header("X-API-KEY", "9H3hyCBR"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn();
		String json = result.getResponse().getContentAsString();
		EngagementParameter parameter = new ObjectMapper().readValue(json, EngagementParameter.class);
		assertEquals(1, parameter.getClicks());
	}

}
