import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] numbers = new int[N];
        int maxLength = 0;

        for(int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }

        int i = 0;
        int curLength = 0;
        while(i < N) {
            if(numbers[i] > T) {
                curLength++;
                maxLength = Math.max(maxLength, curLength);
            }else {
                curLength = 0;
            }
            i++;
        }

        System.out.println(maxLength);
    }
}