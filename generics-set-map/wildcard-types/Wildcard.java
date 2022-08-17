import java.util.Arrays;
import java.util.List;

public class Wildcard {

    public static void main(String[] args) {
        
        List<Integer> myList1 = Arrays.asList(1, 2, 3, 4, 5);
        printAllElements(myList1);
        
        List<String> myList2 = Arrays.asList("abc", "def", "ghi");
        printAllElements(myList2);
        
        List<Object> myList3 = Arrays.asList("abc" , 123, 'd', 20.06);
        printAllElements(myList3);
        
    }

    public static void printAllElements(List<?> list) {
        
        // not is possible add elements in wildcards objects
        // list.add(3);
        
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println();
    }
}