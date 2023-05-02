package level1;

public class 최소직사각형 {
    public static void main(String[] args) {
        //int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        //int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int max_match = 0;

        // 최댓값 max 찾기 & max_match 찾기
        for (int i = 0; i < sizes.length ; i++) {
            if(max <= sizes[i][0]){
                max = sizes[i][0];
                max_match = sizes[i][1];
            }
            if(max <= sizes[i][1]){
                max = sizes[i][1];
                max_match = sizes[i][0];
            }
        }

        // 완탐 -> switch & max_match 변경
        for (int i = 0; i < sizes.length ; i++) {
            // 둘다 크면 max_match를 sizes[i]에서 작은걸로 바꾸기
            max_match = (max_match < sizes[i][0] && max_match < sizes[i][1]) ? Math.min(sizes[i][0], sizes[i][1]) : max_match;
        }
        answer = max * max_match;
        return answer;
    }


}
