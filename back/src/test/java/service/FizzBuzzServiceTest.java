package service;

import app.service.FizzBuzzService;
import app.service.interfaces.FizzBuzzServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceTest {

    @InjectMocks
    private FizzBuzzServiceInterface fizzBuzzService = new FizzBuzzService();

    private List<Long> list;

    @BeforeEach
    void init() {
        list = new ArrayList<>();
       for(int i = 0; i<=10 ; i++){
           list.add((long)(10*Math.random()));
        }
//        list.stream().forEach(
//                x->{
//                    list.add((long)(10*Math.random()));
//                }
//        );
    }

    @Test
    void giveResult(){
        System.out.print(list);
        List<String> listFromBuzzServ =  fizzBuzzService.giveResult(list);
        System.out.print(listFromBuzzServ);
        Assertions.assertTrue(listFromBuzzServ.get(1).getClass().equals(String.class));
    }
}
