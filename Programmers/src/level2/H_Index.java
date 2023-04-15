package level2;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5}; //3
        int[] citations2 = {10, 10, 10, 10, 10}; //5
        int[] citations3 = {6, 5, 5, 5, 3, 2, 1, 0}; // 4
        int[] citations4 = {0, 0, 0, 0, 0}; //0
        int[] citations5 = {100, 100, 100}; //3
        int[] citations6 = {12, 11, 10, 9, 8, 1}; //5
        int[] citations7 = {25, 8, 5, 3, 3}; //3
        System.out.println(solution(citations));
        System.out.println(solution(citations2));
        System.out.println(solution(citations3));
        System.out.println(solution(citations4));
        System.out.println(solution(citations5));
        System.out.println(solution(citations6));
        System.out.println(solution(citations7));
    }
    public static int solution(int[] citations) {

        // citations[i]값이 h보다 값이 같거나 커야함
        // citations[i]이 0보다 큰 값의 count(citations_cnt)가 h보다 같거나 커야함
        // 탐색 종료조건 -> 위의 조건충족X, h이 citation.length보다 클때

        // citations[i]이 0보다 큰 값의 count
        int citations_cnt = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length ; i++) {
            if(citations[i] > 0){citations_cnt++;}
        }
        int h = 0;
        while(true){
            int count = 0;
            if(citations_cnt == 0 || h >= citations_cnt || h == citations.length) {
                return h;
            }
            h++;
            for (int i = 0; i < citations.length ; i++) {
                if(citations[i] >= h){
                    count++;
                }
            }
            if(count <= h) {
                return h;
            }
        }
    }
}
