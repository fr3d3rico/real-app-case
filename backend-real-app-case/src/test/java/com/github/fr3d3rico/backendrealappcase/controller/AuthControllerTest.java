package com.github.fr3d3rico.backendrealappcase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fr3d3rico.backendrealappcase.model.JwtTokenProvider;
import com.github.fr3d3rico.backendrealappcase.repository.RoleRepository;
import com.github.fr3d3rico.backendrealappcase.repository.UserRepository;
import com.github.fr3d3rico.backendrealappcase.services.CustomUserDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AuthControllerTest {
	
	private final String LOGIN_URL = "/api/auth/login";
	private final String REGISTER_URL = "/api/auth/register";
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
    JwtTokenProvider jwtTokenProvider;
	
	@MockBean
	UserRepository users;
	
	@MockBean
	RoleRepository roles;
	
	@MockBean
	private CustomUserDetailsService userService;

    @Test
    public void testWrongLoginGETMethod() throws Exception {
    	mvc.perform(get(LOGIN_URL)
    		      .contentType(MediaType.APPLICATION_JSON))
				  .andExpect(status().is(405));
    		      //.andExpect(status().isOk());
    }
    
    @Test
    public void testWrongLoginPOSTMethodEmptyData() throws Exception {
    	Map<Object, Object> model = new HashMap<>();
    	
    	mvc.perform(post(LOGIN_URL)
    			.content(new ObjectMapper().writeValueAsString(model))
    		    .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(401));
    		    //.andExpect(status().isOk());
    }
    
    @Test
    public void testWrongLoginPOSTMethod() throws Exception {
    	Map<Object, Object> model = new HashMap<>();
    	
    	model.put("email", "ppp@fred.com");
    	model.put("password", "123456");
    	
    	mvc.perform(post(LOGIN_URL)
    			.content(new ObjectMapper().writeValueAsString(model))
    		    .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(401));
    		    //.andExpect(status().isOk());
    }
    
    @Test
    public void testRegisterPOSTMethod() throws Exception {
    	Map<Object, Object> model = new HashMap<>();
    	
    	model.put("email", "frederico2@fred.com");
    	model.put("password", "123456");
    	
    	mvc.perform(post(REGISTER_URL)
    			.content(new ObjectMapper().writeValueAsString(model))
    		    .contentType(MediaType.APPLICATION_JSON))
    		    .andExpect(status().isOk());
    }
	
    @Test
    public void testWrongRegisterGETMethod() throws Exception {
    	mvc.perform(get(REGISTER_URL)
    			.contentType(MediaType.APPLICATION_JSON))
    			.andExpect(status().is(405));
    }
}
