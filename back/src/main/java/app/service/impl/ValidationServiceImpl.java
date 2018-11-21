package app.service.impl;

import app.service.ValidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidService {

    private static final Logger log = LoggerFactory.getLogger(ValidService.class);

    public boolean isValidSizeOfNumber(List<String> list) {
        log.debug("Validation size method is started.");
        return list.stream().noneMatch(s -> s.length() > 18);
    }

    public boolean isPositiveNumber(List<String> list) {
        log.debug("Validation isPositive method is started.");
        return list.stream().noneMatch(s -> (Long.valueOf(s)) < 0);
    }
}
