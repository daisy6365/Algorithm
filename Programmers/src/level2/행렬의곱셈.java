package level2;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] result_arr1 = solution(arr1, arr2);
        int[][] result_arr2 = solution(arr3, arr4);
        for (int i = 0; i < result_arr1.length; i++) {
            for (int j = 0; j < result_arr1[0].length; j++) {
                System.out.print(result_arr1[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < result_arr2.length; i++) {
            for (int j = 0; j < result_arr2[0].length; j++) {
                System.out.print(result_arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        // answer의 [i][j]는 arr1[i][n]와 arr2[n][j]을 서로 곱&합 한것임
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }
}
