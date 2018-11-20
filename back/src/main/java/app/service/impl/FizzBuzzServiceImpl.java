package app.service.impl;

import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private static final Logger log = LoggerFactory.getLogger(FizzBuzzService.class);

    @Override
    public ResponseFizzBuzz replacementProcess(List<String> listOfAnswer) throws NumberFormatException {
        List<String> strings = new ArrayList<>();
        List<Long> longs = listOfAnswer.stream().map(Long::valueOf).collect(toList());
        log.info("Started replacementProcess method.");
        longs.forEach(
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
                    log.debug("Iteration in replacement method is completed.");
                }
        );
        log.info("List is changed");
        return new ResponseFizzBuzz(strings);
    }

}
