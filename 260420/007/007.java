import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        char point = sc.next().charA
        int time = sc.nextInt();
        Code code = new Code(name,point,time);
        code.print();
    }

    public static class Code {
        private String name;
        private char point;
        private int time;

        public Code(String name, char point, int time) {
            this.name = name;
            this.point = point;
            this.time = time;
        }

        public void print() {
            System.out.println("secret code : " + this.name);
            System.out.println("meeting point : " + this.point);
            System.out.println("time : " + this.time);
        }
    }
}

