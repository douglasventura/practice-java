import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuffReaderAndWriter {
    public static void main(String[] args) {
        
        String pathSource = "./txt-files/test.txt";
        String pathDestine = "./txt-files/out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDestine, true));
            BufferedReader br = new BufferedReader(new FileReader(pathSource))) {
            
            String line = br.readLine();

            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
