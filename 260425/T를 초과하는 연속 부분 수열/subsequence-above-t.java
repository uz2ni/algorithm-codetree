import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        int maxLength = 0;
        int curLength = 0;

        for(int i=0; i<N; i++) {
            int num = sc.nextInt();

            if(num > T) {
                curLength++;
                maxLength = Math.max(maxLength, curLength);
            }else {
                curLength = 0;
            }
        }

        System.out.println(maxLength);
    }
}