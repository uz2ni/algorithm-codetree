import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int subX = sc.nextInt();
            int subY = sc.nextInt();
            list.add(new Point(i+1, subX, subY));
        }
        
        // 절대값 가까운 순 > 번호 작은 순(기본)
        list.sort((p1, p2) -> {
            int d1 = Math.abs(p1.x) + Math.abs(p1.y);
            int d2 = Math.abs(p2.x) + Math.abs(p2.y);
            if(d1 != d2) {
                return d1 - d2;
            }
            return p1.index - p2.index;
        });

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).index);
        }

    }
    public static class Point {
        int index;
        int x;
        int y;

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
}