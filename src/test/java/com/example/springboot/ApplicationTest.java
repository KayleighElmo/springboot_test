//Kayleigh Elmo
package com.example.springboot;

import org.hibernate.sql.Template;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDeleteHistory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=hello")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=hello")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("/history").contentType(MediaType.ALL)).andExpect(content().string(not(containsString("hello"))));
    }

    @Test
    void testDeleteCase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=hello")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=HELLO").contentType(MediaType.ALL)).andExpect(content().string(containsString("post has been deleted from history.")));
    }
}