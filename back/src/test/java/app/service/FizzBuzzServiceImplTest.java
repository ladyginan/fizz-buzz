package service;

import app.conf.WebConfig;
import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebConfig.class)
public class FizzBuzzServiceImplTest {

    public List<String> strings;
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @BeforeEach
    void init() {
        strings = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            strings.add(String.valueOf((int) (10 * Math.random())));
        }
    }

    @Test
    public void isReplacementProcessWorking() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(strings);
        List<Long> longs = strings.stream().map(Long::valueOf).collect(toList());
        long countLongs = longs.stream().filter((i) -> i % 15 == 0).count();
        long countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Fizz Buzz")).count();

        assertEquals(countLongs, countStrings);

        countLongs= longs.stream().filter((i) -> i % 3 == 0 && i%15!=0).count();
        countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Fizz")).count();

        assertEquals(countLongs, countStrings);

        countLongs = longs.stream().filter((i) -> i % 5 == 0 && i%15!=0).count();
        countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Buzz")).count();

        assertEquals(countLongs, countStrings);

    }

}
