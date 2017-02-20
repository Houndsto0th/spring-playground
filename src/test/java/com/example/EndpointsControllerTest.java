package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testIndex() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/awesome/");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("GET to index route"));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/awesome/postpoint");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("POST'd to post endpoint"));
    }

    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/awesome/deletepoint");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("DELETE'd to delete endpoint"));
    }
}
