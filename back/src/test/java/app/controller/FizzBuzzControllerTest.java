package app.controller;

import app.conf.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(classes = WebConfig.class)
public class FizzBuzzControllerTest {

    public List<String> strings;
    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        strings = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            strings.add(String.valueOf((int) (10 * Math.random())));
        }
    }

    @BeforeEach
    void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void filterFizzBuzz() throws Exception {
        this.mockMvc.perform(post("/fizzBuzz")
                .contentType("application/json")
                .content("{\"1\" : \"2\"\n" +
                        "  \"1\" : \"2\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
