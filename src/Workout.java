import java.util.*;
import java.util.stream.Collectors;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<testCases; i++){
            String line[] = scanner.nextLine().split(" ");
            int sessionsCount = Integer.parseInt(line[0]);
            int additionalSessions = Integer.parseInt(line[1]);
            ArrayList<Integer> sessions = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            TreeMap<Integer, ArrayList<HashMap<Integer, Integer>>> difficulties = findDifficulty(sessions);
            int minDifficulty = difficulties.lastKey();
            for(Map.Entry<Integer, ArrayList<HashMap<Integer, Integer>>> entry : difficulties.entrySet()) {
                int difference = entry.getKey();
                    additionalSessions-=entry.getValue().size();

                    if(additionalSessions < 0)
                        break;
                    if((difference/2)<=difficulties.higherKey(entry.getKey())){
                        difficulties.higherEntry(entry.getKey()).getValue().addAll(entry.getValue());
                        difficulties.remove(entry.getKey());
                    } else {
                        difficulties.put((difference/2), entry.getValue());
                        difficulties.remove(entry.getKey());
                    }
            }
            System.out.println("Case #"+(i+1)+": "+difficulties.firstKey());
        }
    }
    private static TreeMap<Integer, ArrayList<HashMap<Integer, Integer>>> findDifficulty(ArrayList<Integer> sessions){
        TreeMap<Integer, ArrayList<HashMap<Integer, Integer>>> difficulties = new TreeMap<Integer, ArrayList<HashMap<Integer, Integer>>>(Collections.reverseOrder());
        for (int j=0;j<sessions.size()-1;j++){
            int currentDiff = sessions.get(j+1)-sessions.get(j);
            if(!difficulties.containsKey(currentDiff))
                difficulties.put(currentDiff, new ArrayList<>());
            difficulties.get(currentDiff).add(new HashMap<Integer, Integer>(j, j+1));
        }
        return difficulties;
    }
}
