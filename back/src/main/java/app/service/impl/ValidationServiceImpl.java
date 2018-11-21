package app.service.impl;

import app.service.ValidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class ValidationServiceImpl implements ValidService {

    private static final Logger log = LoggerFactory.getLogger(ValidService.class);

    public boolean isValidSizeOfNumber(List<String> list) {
        log.info("Validation size method is started.");
        AtomicBoolean valid = new AtomicBoolean(true);
        list.forEach(
                x -> {
                    if (x.length() > 18) {
                        valid.set(false);
                        log.info("This number have extra size - " + x);
                    }
                }
        );
        return valid.get();
    }

    public boolean isPositiveNumber(List<String> list) {
        log.info("Validation isPositive method is started.");
        AtomicBoolean valid = new AtomicBoolean(true);
        list.forEach(
                x -> {
                    if ((Long.valueOf(x)) < 0) {
                        valid.set(false);
                        log.info("This number is negative - " + x);
                    }
                }
        );
        return valid.get();
    }
}
