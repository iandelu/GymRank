package com.raccon.GymRank.exercises.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class RestTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected ResultActions GET(String url, Object... urlVars) throws Exception {
        return mockMvc.perform(get(url, urlVars)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    protected ResultActions POST(String url, Object body) throws Exception {
        return mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(toJson(body)))
                .andDo(print());
    }

    protected ResultActions PUT(String url, Object body, Object... urlVars) throws Exception {
        return mockMvc.perform(put(url, urlVars)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(toJson(body)))
                .andDo(print());
    }

    protected ResultActions PATCH(String url, Object body, Object... urlVars) throws Exception {
        return mockMvc.perform(patch(url, urlVars)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(toJson(body)))
                .andDo(print());
    }

    protected ResultActions DELETE(String url, Object... urlVars) throws Exception {
        return mockMvc.perform(delete(url, urlVars)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }


    protected ResultActions GETwithHeaders(String url, MockHttpServletRequestBuilder extra) throws Exception {
        return mockMvc.perform(extra.accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    protected String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    protected <T> T fromResponse(ResultActions result, Class<T> clazz) throws Exception {
        String body = result.andReturn().getResponse().getContentAsString();
        return fromJson(body, clazz);
    }
}