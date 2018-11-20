package app.model;

import java.util.List;

public class ResponseFizzBuzz {
    private List<String> replacedList;

    public ResponseFizzBuzz(List<String> replacedList) {
        this.replacedList = replacedList;
    }

    public List<String> getReplacedList() {
        return replacedList;
    }

    public void setReplacedList(List<String> replacedList) {
        this.replacedList = replacedList;
    }
}
