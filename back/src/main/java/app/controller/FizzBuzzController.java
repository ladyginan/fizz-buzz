package app.controller;

import app.service.FizzBuzzService;
import app.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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


    @PostMapping("/fizz")
    public ResponseEntity<List<String>> filterFizz(@RequestBody List<String> list){
        if(validService.isValidSizeOfNumber(list)) {
            return new ResponseEntity<>(fizzBuzzService.replacementProcess(list),HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
