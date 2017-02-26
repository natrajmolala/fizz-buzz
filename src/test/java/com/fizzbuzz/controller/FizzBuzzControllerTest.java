package com.fizzbuzz.controller;

import com.fizzbuzz.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class FizzBuzzControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnHttpResponseOK() throws Exception {
        String expectedResultJson = "{\"result\":\"Fizz\"}";

        mockMvc.perform(get("/fizzbuzz/9"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(content().string(expectedResultJson))
                .andReturn();
    }

    @Test
    public void shouldReturnHttpResponseNotFound() throws Exception {
        mockMvc.perform(get("/fizzbuzzz/9"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void shouldReturnInvalidResponseTextWhenNonNumberPassed() throws Exception {
        String expectedResultJson = "{\"result\":\"Invalid request param!\"}";

        mockMvc.perform(get("/fizzbuzz/nine"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(content().string(expectedResultJson))
                .andReturn();
    }
}
