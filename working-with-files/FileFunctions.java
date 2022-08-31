import java.io.File;
import java.util.Scanner;

public class FileFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        File file = new File(path);

        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());

        sc.close();
    }
}
