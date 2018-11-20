package app.service.impl;

import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FizzBuzzService.class);
    private List<String> strings = new ArrayList<>();

    @Override
    public ResponseFizzBuzz replacementProcess(List<String> listOfAnswer) {
        List<Long> longs = listOfAnswer.stream().map(Long::valueOf).collect(toList());
        strings.clear();
        log.info("The strings is clear.");
        log.info("Started replacementProcess method.");
        longs.stream().forEach(
                (i) -> {
                    if (i % 15 == 0) {
                        strings.add("Fizz Buzz");
                    } else if (i % 3 == 0) {
                        strings.add("Fizz");
                    } else if (i % 5 == 0) {
                        strings.add("Buzz");
                    } else {
                        strings.add(String.valueOf(i));
                    }
                    log.debug("Iteration in replacement method is completed");
                }
        );
        log.info("List is changed");
        return new ResponseFizzBuzz(strings);
    }

}
