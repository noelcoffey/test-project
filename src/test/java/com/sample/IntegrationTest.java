package com.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
public class IntegrationTest {

    @Autowired
    private MockMvc mvc;
   
    @Test
    public void whenCreatePersonthenStatus200()
      throws Exception {

        mvc.perform(post("/api/person")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{ \"firstName\" : \"John\", \"lastName\" : \"Doe\", \"location\" : \"Dublin\"}"))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.id", is(1)));
        
        mvc.perform(get("/api/person?id=1")
        	.accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk())
        	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        	.andExpect(jsonPath("$.firstName").value("John"))
        	.andExpect(jsonPath("$.lastName").value("Doe"));       
    }
}
