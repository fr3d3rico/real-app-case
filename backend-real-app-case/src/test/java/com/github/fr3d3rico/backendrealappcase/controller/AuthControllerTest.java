package com.github.fr3d3rico.backendrealappcase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.fr3d3rico.backendrealappcase.model.JwtTokenProvider;
import com.github.fr3d3rico.backendrealappcase.repository.RoleRepository;
import com.github.fr3d3rico.backendrealappcase.repository.UserRepository;
import com.github.fr3d3rico.backendrealappcase.services.CustomUserDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AuthControllerTest {
	
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
    public void testLogin() throws Exception {
    	mvc.perform(get("/api/auth/login")
    		      .contentType(MediaType.APPLICATION_JSON))
				  .andExpect(status().is(405));
    		      //.andExpect(status().isOk());
    }
	
}
