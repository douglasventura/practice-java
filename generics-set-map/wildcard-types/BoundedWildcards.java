import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundedWildcards {
    
    public static void main(String[] args) {
        
        List<Object> myList = new ArrayList<Object>();
        List<Integer> myInts = Arrays.asList(1, 2, 3);
        List<Double> myDoubles = Arrays.asList(3.5, 7.2, 32.34);

        copy(myInts, myList);
        print(myList);
        
        copy(myDoubles, myList);
        print(myList);

    }

    // delimited wildcards: super and extends imply different ways of accessing their elements.
    // extends: I can to get elements, but I can't to put elements.  -> covariance
    // super: I can to to put elements, but I can't to get elements. -> conter-covariance
    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void print(List<?> list) {
        for (Object object : list) {
            System.out.print(object + ", ");
        }
        System.out.println();
    }
}
