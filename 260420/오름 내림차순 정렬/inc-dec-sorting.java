import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
           System.out.print(arr[i] + " ");
        }

        System.out.println();

        // sol1
        // Arrays.sort(arr, (a,b) -> b-a);

        // sol2
        Arrays.sort(arr, Collections.reverseOrder());

        // sol3 (기존 배열 int[]로 받는다면, int[]->Integer[] 변환 후 정렬 )
        // Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        for(int i=0; i<arr.length; i++) {
           System.out.print(arr[i] + " ");
        }


    }
}