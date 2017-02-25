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
@WebMvcTest(QueryEndpointsController.class)
public class QueryEndpointsControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testIndividualByName() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/queries/individuallybyname?muffin=blueberry");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The muffin is : blueberry"));

    }

    @Test
    public void testAsHashMap() throws Exception {
        String baconType = "tenderbelly";
        String coffeeType = "ethiopian";

        RequestBuilder request = MockMvcRequestBuilders.get("/queries/ashash?coffee=ethiopian&bacon=tenderbelly");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{coffee=" + coffeeType + ", bacon=" + baconType + "}"));
    }

    @Test
    public void testAsCustomObject() throws Exception {
        String juice = "Orange";
        String meat = "Hashed Beef";

        RequestBuilder request = MockMvcRequestBuilders.get("/queries/asobject?juice=" + juice + "&" + "meat=" + meat);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Breakfast today will be " + juice + " juice with a side of " + meat));
    }
}
