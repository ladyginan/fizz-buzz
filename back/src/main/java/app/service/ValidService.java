package app.service;

import java.util.List;

public interface ValidService {
    /**
     * This method check elements from List<String> for valid.
     * If element have size more then 3, it is not valid.
     * @param list List of String elements from user's input
     * @return boolean
     */
    boolean isValidSizeOfNumber(List<String> list);
}
