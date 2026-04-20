import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] charArr = str.toCharArray();
        
        Arrays.sort(charArr);
        String result = new String(charArr);

        System.out.println(result);
        
    }
}