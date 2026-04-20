import java.util.*;
public class Main {
    public static void main(String[] args) {
    
        solution2();
        
    }

    public static void solution1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] subArr;
        for(int i=0; i<n; i+=2) {
            subArr = Arrays.copyOfRange(arr,0,i+1);
            Arrays.sort(subArr);
            // 중앙값
            int centerIdx = subArr.length / 2;
            System.out.print(subArr[centerIdx] + " ");
        }
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if(i % 2 == 0) {
                Arrays.sort(arr, 0, i+1);
                System.out.print(arr[i/2] + " ");
            }
            
        }
    }
}