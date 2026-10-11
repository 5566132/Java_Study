import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5,6,7);
        List<Integer> newlist = list.stream()
        //        .map(num -> Integer.parseInt(num))
                .filter(num -> (num%2)==0?false:true)
        //        .toList();
                .collect(Collectors.toList());
        for(Integer temp : newlist){
            System.out.println(temp);
        }


    }
}
