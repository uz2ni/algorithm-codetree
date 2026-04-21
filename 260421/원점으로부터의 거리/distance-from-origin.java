import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        int subX;
        int subY;
        int subDistance;
        for(int i=0; i<n; i++) {
            subX = sc.nextInt();
            subY = sc.nextInt();
            // 절대값
            subDistance = Math.abs(subX) + Math.abs(subY);
            list.add(new Point(i+1, subX, subY, subDistance));
        }
        
        // 절대값 가까운 순 > 번호 작은 순(기본)
        list.sort((p1, p2) -> p1.distance - p2.distance);

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).index);
        }

    }
    public static class Point {
        int index;
        int x;
        int y;
        int distance;

        public Point(int index, int x, int y, int distance) {
            this.index = index;
            this.x = x;
            this.y = y;
            this. distance = distance;
        }
    }
}