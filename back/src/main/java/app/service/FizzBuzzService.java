package app.service;

import app.service.interfaces.FizzBuzzServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService implements FizzBuzzServiceInterface {

    private List<String> list = new ArrayList<>();
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FizzBuzzServiceInterface.class);

    @Override
    public List<String> giveResult(List<Long> listOfAnswer) {
            list.clear();
            log.info("The list is clear.");
            log.info("Started giveResult method.");
            listOfAnswer.stream().forEach(
                    ( i )->{
                        if (i % 15 == 0) {
                           list.add("Fizz Buzz");
                        }
                        else if (i%3 ==0) {
                            list.add("Fizz");
                        } else if (i%5==0){
                            list.add("Buzz");
                        } else{
                            list.add(String.valueOf(i));
                        }
                        log.debug("Iteration is completed");
                    }
            );
            log.info("The iteration is completed.");
            return list;
    }



}
