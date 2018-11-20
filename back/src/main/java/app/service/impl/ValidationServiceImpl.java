package app.service.impl;

import app.service.ValidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidService {

    private static final Logger log = LoggerFactory.getLogger(ValidService.class);
    private boolean valid;

    public boolean isValidSizeOfNumber(List<String> list) {
        log.info("Validation size method is started.");
        valid = true;
        list.forEach(
                x -> {
                    if (x.length() > 18) {
                        valid = false;
                        log.info("This number have extra size - " + x);
                    }
                }
        );
        return valid;
    }

    public boolean isPositiveNumber(List<String> list){
        log.info("Validation isPositive method is started.");
        valid = true;
        list.forEach(
                x -> {
                    if ((Long.valueOf(x))<0) {
                        valid = false;
                        log.info("This number is negative - " + x);
                    }
                }
        );
        return valid;
    }
}
