import java.util.Arrays;

// 주석된 방식으로 하면 시간초과 발생. but 정령 알고리즘 사용
public class 최솟값만들기 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
//        min_arr(A);
//        max_arr(B);
//
//        for (int i = 0; i < A.length; i++) {
//            answer += (A[i] * B[i]);
//        }

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[A.length-i-1]);
        }
        return answer;
    }

//    static int[] min_arr(int[] A){
//        int temp = A[0];
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i+1; j < A.length; j++) {
//                if(A[i] < A[j]){
//                    temp = A[i];
//                    A[i] = A[j];
//                    A[j] = temp;
//                }
//            }
//        }
//        return A;
//    }
//
//    static int[] max_arr(int[] B){
//        int temp = B[0];
//        for (int i = 0; i < B.length; i++) {
//            for (int j = i+1; j < B.length; j++) {
//                if(B[i] > B[j]){
//                    temp = B[i];
//                    B[i] = B[j];
//                    B[j] = temp;
//                }
//            }
//        }
//        return B;
//    }

    public static void main(String[] args) {
        int [] A = {1, 4, 2};
        int [] B = {5, 4, 4};
        solution(A, B);
    }
}
