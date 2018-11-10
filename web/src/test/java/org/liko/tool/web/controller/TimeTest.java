package org.liko.tool.web.controller;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeTest {

    @Autowired
    private MockMvc mvn;

    @Test
    public void timestampToDate() throws Exception {
        mvn.perform(MockMvcRequestBuilders.get("/todate").param("timestamp", "1541865600000")
                    .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                    .andExpect(content().string(equalTo("2018-11-11 00:00:00")));
    }

    @Test
    public void dateToTimestamp() throws Exception {
        mvn.perform(MockMvcRequestBuilders.get("/totimestamp").param("date", "2018-11-11 00:00:00").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("1541865600000")));
    }

}