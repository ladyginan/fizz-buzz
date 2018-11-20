package service;

import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import app.service.impl.FizzBuzzServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceImplTest {

    @Autowired
    private FizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();

    public List<String> strings;

    @BeforeEach
    void init() {
        strings = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            strings.add(String.valueOf((int)(10 * Math.random())));
        }
    }

    @Test
    public void isFizzFilterWorking(){
       ResponseFizzBuzz response = fizzBuzzService.replacementProcess(strings);
        List<Long> longs = strings.stream().map(Long::valueOf).collect(toList());
        long countLongs = longs.stream().filter((i) -> i%15==0).count();
        long countStrings= response.getReplacedList().stream().filter((i) -> i.equals("Fizz Buzz")).count();
        assertEquals(countLongs, countStrings);

    }



}
