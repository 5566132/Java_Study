package Function_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2" , "3", "4", "5");
        list.stream()
                .map(Integer::parseInt())





    }
}
