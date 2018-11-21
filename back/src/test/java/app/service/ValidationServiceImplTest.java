package app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationServiceImplTest {

    private List<String> strings;
    private List<String> negativeValues;

    @Autowired
    private ValidationService validationService;

    @Before
    public void init() {
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
    public void isPositiveNumber() {
        assertTrue(validationService.isPositiveNumber(strings));
        assertFalse(validationService.isPositiveNumber(negativeValues));
    }

    @Test
    public void isValidSizeOfNumber() {
        assertTrue(validationService.isValidSizeOfNumber(strings));
        strings.add("1111111111111111111111111111111111111111");
        assertFalse(validationService.isValidSizeOfNumber(strings));
    }
}
