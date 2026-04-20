import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();

        Data data = new Data("codetree", 10);
        Data data2 = new Data(id, level);

        data.print();
        data2.print();
        
    }

    public static class Data {
        
        private String id;
        private int level;

        public Data(String id, int level) {
            this.id = id;
            this.level = level;
        }

        public void print() {
            System.out.print("user " + this.id + " lv " + this.level);
            System.out.println();
        }

    }
}