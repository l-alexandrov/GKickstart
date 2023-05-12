import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Bundling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<testCases; i++) {
            String line[] = scanner.nextLine().split(" ");
            int strings = Integer.parseInt(line[0]);
            int elementsInGroup = Integer.parseInt(line[1]);
            HashMap<Integer, List<List<String>>> groups = new HashMap<>();
            for (int j=0; j<strings; j++){
                String tmp = scanner.nextLine();
                for(int k=groups.size()-1;k!=0;k--){
                }
            }

        }
    }
}
