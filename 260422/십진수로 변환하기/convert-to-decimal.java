import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int result = 0;

        for(int i=0; i<n.length(); i++) {
            char c = n.charAt(n.length()-1-i);
            int num = c-'0';
            result += (num * getZeGop(i));
        }
        
        System.out.println(result);
    }

    public static int getZeGop(int a) {
        int result = 1;

        if(a == 0) return 1;
        
        while(a-- > 0) {
            result *= 2;
        }
        return result;
    }
}