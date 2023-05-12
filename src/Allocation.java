import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<testCases; i++){
            String line[] = scanner.nextLine().split(" ");
            int houses = Integer.parseInt(line[0]);
            int budget = Integer.parseInt(line[1]);
            int prices[];
            prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(prices);
            int cnt = 0;
            for (int j=0;j<houses;j++){
                if(prices[j]>budget) {
                    break;
                }
                budget -=  prices[j];
                cnt++;
            }
            System.out.println("Case #"+(i+1)+": "+cnt);
        }
    }
}
