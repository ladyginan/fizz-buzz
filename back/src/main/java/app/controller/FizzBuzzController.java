package app.controller;

import app.model.ResponseFizzBuzz;
import app.service.FizzBuzzService;
import app.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;
    private final ValidService validService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService, ValidService validService) {
        this.fizzBuzzService = fizzBuzzService;
        this.validService = validService;
    }

    @PostMapping("/fizzBuzz")
    public ResponseEntity<ResponseFizzBuzz> filterFizzBuzz(@RequestBody List<String> list) {
        if (validService.isValidSizeOfNumber(list)) {
            return new ResponseEntity<>(fizzBuzzService.replacementProcess(list), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
