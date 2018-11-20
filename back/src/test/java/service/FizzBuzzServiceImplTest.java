package service;

import app.service.FizzBuzzService;
import app.service.impl.FizzBuzzServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceImplTest {

    @Autowired
    private FizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();

    private List<String> list;

    @BeforeEach
    void init() {
        list = new ArrayList<>();
       for(int i = 0; i<=10 ; i++){
           list.add(String.valueOf(10*Math.random()));
        }
//        list.stream().forEach(
//                x->{
//                    list.add((long)(10*Math.random()));
//                }
//        );
    }

//    @Test
//    void giveResult(){
//        System.out.print(list);
//        ResponseFizzBuzz listFromBuzzServ =  fizzBuzzService.replacementProcess(list);
//        System.out.print(listFromBuzzServ);
//        Assertions.assertTrue(listFromBuzzServ.get(1).getClass().equals(String.class));
//    }
}
