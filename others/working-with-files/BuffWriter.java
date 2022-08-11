import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BuffWriter {
    public static void main(String[] args) {
        
        String[] lines = new String[] { "Douglas", "Dayanne", "Luanna" };
        String path = "./txt-files/out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
