package app.service;

import app.model.ResponseFizzBuzz;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceImplTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    private List<String> strings;

    @Before
    public void init() {
        strings = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            strings.add(String.valueOf((int) (10 * Math.random())));
        }
    }

    @Test
    public void isReplacementProcessWorkingFizzBuzz() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(strings);
        List<Long> longs = strings.stream().map(Long::valueOf).collect(toList());

        long countLongs = longs.stream().filter((i) -> i % 15 == 0).count();
        long countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Fizz Buzz")).count();

        assertEquals(countLongs, countStrings);
    }

    @Test
    public void isReplacementProcessWorkingFizz() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(strings);
        List<Long> longs = strings.stream().map(Long::valueOf).collect(toList());

        long countLongs = longs.stream().filter((i) -> i % 3 == 0 && i % 15 != 0).count();
        long countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Fizz")).count();

        assertEquals(countLongs, countStrings);
    }

    @Test
    public void isReplacementProcessWorkingBuzz() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(strings);
        List<Long> longs = strings.stream().map(Long::valueOf).collect(toList());

        long countLongs = longs.stream().filter((i) -> i % 5 == 0 && i % 15 != 0).count();
        long countStrings = response.getReplacedList().stream().filter((i) -> i.equals("Buzz")).count();

        assertEquals(countLongs, countStrings);

    }

    @Test
    public void isReplacementFizzCorrect() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(Arrays.asList("1", "2", "3"));

        assertEquals(response.getReplacedList(), Arrays.asList("1", "2", "Fizz"));
    }

    @Test
    public void isReplacementBuzzCorrect() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(Arrays.asList("1", "2", "5"));

        assertEquals(response.getReplacedList(), Arrays.asList("1", "2", "Buzz"));
    }

    @Test
    public void isReplacementBuzzBuzzCorrect() {
        ResponseFizzBuzz response = fizzBuzzService.replacementProcess(Arrays.asList("1", "2", "15"));

        assertEquals(response.getReplacedList(), Arrays.asList("1", "2", "Fizz Buzz"));
    }

    @Test(expected = NumberFormatException.class)
    public void isReplacementBuzzBuzzException() {
        fizzBuzzService.replacementProcess(Arrays.asList("1", "2", "3333333333333333333333333333333"));
    }


}
