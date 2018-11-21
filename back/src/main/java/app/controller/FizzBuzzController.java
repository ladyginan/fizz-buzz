package app.controller;

import app.service.FizzBuzzService;
import app.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {

    private static final Logger log = LoggerFactory.getLogger(FizzBuzzController.class);
    private final FizzBuzzService fizzBuzzService;
    private final ValidationService validationService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService, ValidationService validationService) {
        this.fizzBuzzService = fizzBuzzService;
        this.validationService = validationService;
    }

    @GetMapping(path = "/fizzBuzz/{numbers}")
    public ResponseEntity filterFizzBuzz(@PathVariable List<String> numbers) {
        if (validationService.isNumber(numbers) && validationService.isValidSizeOfNumber(numbers) && validationService.isPositiveNumber(numbers)) {
            try {
                return new ResponseEntity<>(fizzBuzzService.replacementProcess(numbers), HttpStatus.OK);
            } catch (NumberFormatException e) {
                log.info("Some of given numbers are invalid");
                return new ResponseEntity<>("Some of given numbers are invalid", HttpStatus.BAD_REQUEST);
            }
        } else {
            log.info("Some of given numbers are not a numbers or too big or not positive.");
            return new ResponseEntity<>("Some of given numbers are not a numbers or too big or not positive.", HttpStatus.BAD_REQUEST);
        }
    }

}
