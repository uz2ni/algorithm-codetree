import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n>=2) {
            sb.append(n%2);
            n /= 2;
        }

        sb.append(n);
        System.out.println(sb.reverse());
    }
}