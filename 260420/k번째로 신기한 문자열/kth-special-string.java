import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 개수
        int k = sc.nextInt(); // k번째
        String t = sc.next(); // 시작 문자열

        String[] keywords = new String[n];
        for(int i=0; i<n; i++) {
            keywords[i] = sc.next();
        }

        // T 문자열로 시작하는 문자열만 추출
        List<String> filtered = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(keywords[i].startsWith(t)) {
                filtered.add(keywords[i]);
            }
        }

        // 사전순 정렬
        Collections.sort(filtered);

        // K번째 문자열 출력
        System.out.println(filtered.get(k-1));
        
    }
}