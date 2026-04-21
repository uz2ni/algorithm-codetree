import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] a = new Point[n];
        Point[] b;
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            a[i] = new Point(i, x);
        }   

        /* sol 1 */
        /*
        b = Arrays.copyOfRange(a, 0, n);
        Arrays.sort(b, (p1, p2) -> {
            if(p1.x != p2.x) {
                return p1.x - p2.x;
            }
            return p1.index - p2.index;
        });

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<b.length; j++) {
                if(a[i].index == b[j].index) {
                    System.out.print(j+1 + " ");
                    break;
                }
            }
        }
        */

        /* sol 2 */
        Arrays.sort(a, (p1, p2) -> {
            if(p1.x != p2.x) {
                return p1.x - p2.x;
            }
            return p1.index - p2.index;
        });

        int[] result = new int[n];
        
        // 정렬된 값의 index 위치 result에 순위 기입
        for(int i=0; i<n; i++) {
            result[a[i].index] = i+1;
        }

        for(int i : result) {
            System.out.print(i + " ");
        }

    }

    public static class Point {
        int index;
        int x;
        public Point (int index, int x) {
            this.index = index;
            this.x = x;
        }
    }
}