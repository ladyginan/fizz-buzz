package app.service.impl;

import app.service.FizzBuzzService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FizzBuzzService.class);
    private List<String> list = new ArrayList<>();

    @Override
    public List<String> replacementProcess(List<String> listOfAnswer) {
        List<Long> listOfLongValues = new ArrayList<>();
        list.stream().forEach(i -> listOfLongValues.add(Long.valueOf(i)));
        list = new ArrayList<>();
        log.info("The list is clear.");
        log.info("Started replacementProcess method.");
        listOfLongValues.stream().forEach(
                (i) -> {
                    if (i % 15 == 0) {
                        list.add("Fizz Buzz");
                    } else if (i % 3 == 0) {
                        list.add("Fizz");
                    } else if (i % 5 == 0) {
                        list.add("Buzz");
                    } else {
                        list.add(String.valueOf(i));
                    }
                    log.debug("Iteration is completed");
                }
        );
        log.info("The iteration is completed.");
        return list;
    }

}
