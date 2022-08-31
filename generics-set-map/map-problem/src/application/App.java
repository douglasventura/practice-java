import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    
    public static void main(String[] args) {
        
        String path = "generics-set-map/map-problem/files/in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            Map<String, Integer> votes = new LinkedHashMap<>();
            String line = br.readLine();

            while (line != null) {
                String[] data = line.split(",");
                String name = (String) data[0];
                Integer numVotes = Integer.parseInt(data[1]);
                
                if (votes.containsKey(name)) {
                    numVotes += votes.get(name);
                    votes.put(name, numVotes);
                } else {
                    votes.put(name, numVotes);
                }

                line = br.readLine();
            }

            for (String candidate : votes.keySet()) {
                System.out.println(candidate + ": " + votes.get(candidate));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}