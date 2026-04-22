import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> lines = new HashMap<>();
        for(int i=0; i<n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            for(int j=x1; j<=x2; j++) {
                int value = lines.getOrDefault(j, 0);
                lines.put(j, ++value);
            }
        }

        int max = 0;
        for(Map.Entry<Integer,Integer> entry : lines.entrySet()) {
            max = Math.max(max, entry.getValue());
        }        

        System.out.println(max);
    }
}