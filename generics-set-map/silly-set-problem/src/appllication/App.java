import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            
            Set<Integer> courceA = new HashSet<>();
            Set<Integer> courceB = new HashSet<>();
            Set<Integer> courceC = new HashSet<>();
            
            System.out.print("How many students for course A? ");
            int students = sc.nextInt();
                
            for (int i = 0; i < students; i++) {
                courceA.add(sc.nextInt());
            }

            System.out.print("How many students for course B? ");
            students = sc.nextInt();

            for (int i = 0; i < students; i++) {
                courceB.add(sc.nextInt());
            }

            System.out.print("How many students for course C? ");
            students = sc.nextInt();

            for (int i = 0; i < students; i++) {
                courceC.add(sc.nextInt());
            }
            
            Set<Integer> totalStudents = new HashSet<>(courceA);
            totalStudents.addAll(courceB);
            totalStudents.addAll(courceC);

            System.out.println("Total students: " + totalStudents.size());
        
        } catch (Exception e) {
            e.getMessage();
        }

    }
}