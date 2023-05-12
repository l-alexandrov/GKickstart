import java.util.Arrays;
import java.util.Scanner;

public class Plates {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<testCases; i++){
            String line[] = scanner.nextLine().split(" ");
            int stacks = Integer.parseInt(line[0]);
            int platesInStack = Integer.parseInt(line[1]);
            int platesNeeded = Integer.parseInt(line[2]);
            int plates[][] = new int[stacks][];
            for(int j=0 ; j< stacks; j++){
                plates[j] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int cnt = 0;
            for (int j=0;j<stacks;j++){
                if(j==0){
                    for(int k=0; k<platesInStack;k++){
                        if(platesNeeded>0){
                            platesNeeded--;
                            cnt+= plates[j][k];
                        } else {
                            break;
                        }
                    }
                    continue;
                }
            }
            System.out.println("Case #"+(i+1)+": "+cnt);
        }
    }
}
