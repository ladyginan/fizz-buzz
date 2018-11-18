package app.controller;

import app.service.interfaces.FizzBuzzServiceInterface;
import app.service.interfaces.ValidServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class FizzBuzzController {

    @Autowired
    private FizzBuzzServiceInterface fizzBuzzService;
    @Autowired
    private ValidServiceInterface validServiceInterface;


    @PostMapping("/fizz")
    public ResponseEntity<List<String>> filterFizz(@RequestBody List<String> list){
        List<Long> listOfLongValues = new ArrayList<>();
        if(validServiceInterface.isValidSizeOfNumber(list)) {
            list.stream().forEach(i -> listOfLongValues.add(Long.valueOf(i)));
            return new ResponseEntity<>(fizzBuzzService.giveResult(listOfLongValues),HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
