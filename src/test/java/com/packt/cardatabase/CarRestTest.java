package com.packt.cardatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAuthentication() throws Exception{
		//Test authentication with the correct credentials
		this.mockMvc.perform(post("/login")
					.content("{\"username\":\"admin\", \"password\":\"simplepw\"}"))
					.andDo(print())
					.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
