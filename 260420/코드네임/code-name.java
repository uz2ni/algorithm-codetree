import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char name;
        int score;
        List<Code> list = new ArrayList<>();
        for(int i=0; i<5; i++) {
            name = sc.next().charAt(0);
            score = sc.nextInt();
            list.add(new Code(name, score));
        }
        
        list.sort((c1,c2)->c1.score-c2.score);
        
        System.out.println(list.get(0).name + " " + list.get(0).score);
    }

    public static class Code {
        char name;
        int score;

        public Code(char name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}   