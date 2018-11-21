package app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void checkFizz() throws Exception {
        this.mockMvc.perform(get("/fizzBuzz/1,2,3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fizz")));
    }

    @Test
    public void checkBuzz() throws Exception {
        this.mockMvc.perform(get("/fizzBuzz/1,2,5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Buzz")));
    }

    @Test
    public void checkFizzBuzz() throws Exception {
        this.mockMvc.perform(get("/fizzBuzz/1,2,15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Fizz Buzz")));
    }

    @Test
    public void checkInvalidInput() throws Exception {
        this.mockMvc.perform(get("/fizzBuzz/asd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Some of given numbers are not a numbers or too big or not positive.")));
    }
}
