import java.io.IOException;
import java.util.*;

// DFS 사용
public class BOJ_2667_단지번호붙이기 {
    static int N, house_count;
    // 상 좌 우 하
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};
    static int[][] map;
    static boolean[][] isSelected;
    static ArrayList<Integer> count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isSelected = new boolean[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 단지 시작점 찾아서 DFS
        count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isSelected[i][j] && map[i][j] == 1){
                    // 단지 내 집 수 초기화
                    house_count = 1;
                    dfs(i, j);
                    // 단지 내 집 수 리스트에 넣기
                    count.add(house_count);
                }
            }
        }


        // 단지 내 집의 수 오름차순 정렬
        count.sort(Comparator.naturalOrder());
        System.out.println(count.size());
        while(!count.isEmpty()){
            System.out.println(count.get(0));
            count.remove(0);
        }

    }
    private static void dfs(int start_i, int start_j){
        isSelected[start_i][start_j] = true;

        for (int d = 0; d < 4; d++) {
            int next_i = start_i + di[d];
            int next_j = start_j + dj[d];

            if(next_i >= 0 && next_i < N && next_j >= 0 && next_j < N){
                // 연결된 곳이 1(집)이라면
                if(map[next_i][next_j] == 1 && !isSelected[next_i][next_j]){
                    house_count++; // 단지 내 집 수 카운트
                    dfs(next_i, next_j); // DFS 다시 시작
                }
            }
        }
    }
}
