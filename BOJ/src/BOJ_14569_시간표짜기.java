import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비트마스킹
/*
 * x << y : x의 각 비트를 y만큼 왼쪽으로 이동, 오른쪽 빈자리 = 0
 * x >> y : x의 각 비트를 y만큼 오른쪽으로 이동, 왼쪽 빈자리 = x의 최상위 부호비트와 같음
 * x >>> y : x의 각 비트를 y만큼 오른쪽으로 이동, 왼쪽 빈자리 = 0
 * 원소 추가	A |= (1 << k);	k번째 비트 켜기
 * 원소 삭제	A &= ~(1 << k);	k번째 비트 끄기
 *
 * 비트 논리 연산자
 * &	AND	-> 두 비트 모두 1이면 1
 * |	OR	-> 두 비트 중 1개만 1이면 1
 * ^	XOR -> 두 비트가 서로 다르면 1
 * ~	NOT -> 비트 반전(보수)
 * */
public class BOJ_14569_시간표짜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 50개 -> long
        long[] class_arr = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 총 수업
            for (int j = 0; j < k; j++) {
                int temp_class = Integer.parseInt(st.nextToken());
                class_arr[i] |= (1L << temp_class); // 해당 temp_class시간 켜기
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 학생들의 비어있는 시간
            long student_empty = 0;
            for (int j = 0; j < p; j++) {
                int q = Integer.parseInt(st.nextToken());
                student_empty |= (1L << q); // 학생의 빈 시간 켜기
            }

            // 해당 과목 수업의 시간--학생 빈시간 과 비교해서 둘다 1로 하게 함
            // 1이 해당 과목 수업과 같은 값일때 카운트
            for (int j = 0; j < N; j++) {
                if((class_arr[j] & student_empty) == class_arr[j]) count++;
            }
            System.out.println(count);
        }
    }
}
