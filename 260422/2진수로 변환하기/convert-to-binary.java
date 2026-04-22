import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int remain;
        String result = "";
        while(n>=2) {
            remain = n%2;
            n = n/2;
            result = remain + result;
        }

        result = n + result;
        System.out.println(result);
    }
}