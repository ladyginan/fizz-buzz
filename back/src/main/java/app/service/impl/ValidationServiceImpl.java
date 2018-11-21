package app.service.impl;

import app.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService {

    private static final Logger log = LoggerFactory.getLogger(ValidationService.class);

    @Override
    public boolean isValidSizeOfNumber(List<String> list) {
        log.debug("Validation size method is started.");
        return list.stream().noneMatch(s -> s.length() > 18);
    }

    @Override
    public boolean isPositiveNumber(List<String> list) {
        log.debug("Validation isPositive method is started.");
        return list.stream().noneMatch(s -> (Long.valueOf(s)) < 0);
    }

    @Override
    public boolean isNumber(List<String> list) {
        log.debug("Validation isNumber method is started.");
        try {
            list.forEach(Long::valueOf);
        } catch (NumberFormatException e) {
            log.info("Input string is not a number: ", e.getCause());
            return false;
        }
        return true;
    }
}
