package app.service.impl;

import app.service.ValidService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidService {

    private boolean valid;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ValidService.class);




    public boolean isValidSizeOfNumber(List<String> list){
        valid = true;
        list.forEach(
                x->{
                    if(x.length()>18){
                        valid = false;
                        log.info("This number have extra size - " + x);
                    }
//                    if(x.length()<1){
//                        valid = false;
//                        log.info("This number is null- " + x);
//                    }
                }
        );
        return valid;
    }
}
