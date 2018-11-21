package app.controller;

import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import app.service.ValidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class FizzBuzzController {

    private static final Logger log = LoggerFactory.getLogger(FizzBuzzController.class);
    private final FizzBuzzService fizzBuzzService;
    private final ValidService validService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService, ValidService validService) {
        this.fizzBuzzService = fizzBuzzService;
        this.validService = validService;
    }

    @PostMapping(path = "/fizzBuzz", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseFizzBuzz> filterFizzBuzz(@RequestBody List<String> list) {
        try {
            if (validService.isValidSizeOfNumber(list) && validService.isPositiveNumber(list)) {
                return new ResponseEntity<>(fizzBuzzService.replacementProcess(list), HttpStatus.OK);
            }
        } catch (NumberFormatException e) {
            log.debug("This number is invalid.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
