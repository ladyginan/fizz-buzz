package app.service.interfaces;

import java.util.List;


public interface FizzBuzzServiceInterface {
    /**
     * Given a list with replaced numbers, which
     * multiples of three - "Fizz"
     * multiples of five - "Buzz"
     * multiples of five and three - "Fizz"
     * @param list List of String elements from user's input
     * @return List of elements
     */

    List<String> giveResult(List<Long> list);
}
