package app.model;

import java.io.Serializable;
import java.util.List;

public class ResponseFizzBuzz implements Serializable {
    private List<String> replacedList;

    public List<String> getReplacedList() {
        return replacedList;
    }

    public void setReplacedList(List<String> replacedList) {
        this.replacedList = replacedList;
    }

    public ResponseFizzBuzz(List<String> replacedList) {
        this.replacedList = replacedList;
    }
}
