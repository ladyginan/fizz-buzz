package app.service;

import app.conf.WebConfig;
import app.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebConfig.class)
public class ValidationServiceImplTest {

    public List<String> strings;
    public List<String> negativeValues;

    @Autowired
    private ValidService validationService;

    @BeforeEach
    void init() {
        strings = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            strings.add(String.valueOf((int) (10 * Math.random())));
        }

        negativeValues = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            strings.add(String.valueOf((int) (10 * Math.random())));
        }
        negativeValues.add("-1");

    }
    @Test
    void isPositiveNumber(){
        assertTrue(validationService.isPositiveNumber(strings));
        assertFalse(validationService.isPositiveNumber(negativeValues));
    }

    @Test
    void isValidSizeOfNumber(){
        assertTrue(validationService.isValidSizeOfNumber(strings));
        strings.add("1111111111111111111111111111111111111111");
        assertFalse(validationService.isValidSizeOfNumber(strings));
    }
}
