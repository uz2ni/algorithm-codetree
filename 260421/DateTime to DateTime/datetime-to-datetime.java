import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 일
        int b = sc.nextInt(); // 시
        int c = sc.nextInt(); // 분

        int sub = toMinuite(a,b,c) - toMinuite(11,11,11);
        System.out.print(sub < 0 ? -1 : sub);
    }

    public static int toMinuite(int a, int b, int c) {
        return (a*24*60) + (b*60) + c;
    }
}