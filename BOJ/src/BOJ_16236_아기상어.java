import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236_아기상어 {
    // 상어 좌표 i,j, 상어크기, 현재 먹은 먹이(성장하면 초기화)
    static int shark_i, shark_j, shark_w, shark_eat;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};

    static int N; //지도 크기
    static int[][] map; // 지도배열
    static boolean[][] isSelected;

    static int ans; // 상어의 식사(이동)시간
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9){
                    //상어의 초기 위치
                    shark_i = i;
                    shark_j = j;
                    shark_w = 2;
                    map[i][j] = 0; //상어있는 위치 just 빈칸
                }
            }
        }

        while (true){
            //현재 상어 위치에서 먹을수 있는 먹이 있는지 탐색
            boolean result = bfs();
            if (!result){ // 먹을 수 있는게 없음 -> 탐색 끝
                break;
            }
        }
        System.out.println(ans);
    }

    public static boolean bfs(){
        Queue<Point> queue = new LinkedList<>();
        isSelected = new boolean[N][N];

        queue.add(new Point(shark_i,shark_j));
        isSelected[shark_i][shark_j] = true;

        int dist = 0; //먹이 까지의 거리
        int feed_i =N, feed_j = N; // 먹이 있다없다 + 위치 체크 변수 (i,j가 작을 수록 상,좌에 존재)
        while(!queue.isEmpty()){//상어가 이동가능한 후보칸이 남아있는 한 계속 탐색
            int size = queue.size(); //현재 이동가능한 곳이 몇개 있는지 (출발점에서 같은 거리에 있는 스케줄 갯수)

            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    //이동 불가
                    if(nexti <0 || nextj<0 || nexti>=N || nextj>=N || map[nexti][nextj] > shark_w) continue;
                    //이동만 가능
                    else if((map[nexti][nextj]==0 || map[nexti][nextj]==shark_w) && !isSelected[nexti][nextj]){
                        queue.add(new Point(nexti,nextj));
                        isSelected[nexti][nextj] = true;
                    }
                    //먹이인 경우
                    else if(map[nexti][nextj] < shark_w && map[nexti][nextj]>0){
                        if(nexti < feed_i){//높이가 위면 무조건 먹음
                            feed_i = nexti;
                            feed_j = nextj;
                        }
                        else if(nexti == feed_i){//기존에 찾아놓은 다른 먹이랑 높이 같으면 더 왼쪽
                            feed_j = Math.min(nextj,feed_j);
                        }
                    }
                }
            }// 같은 거리에 있는 좌표 뺐으면 큐에 좌표 남았어도 일단 정지

            /*
            먹이 없었으면 계속 진행
            먹이 있으면 먹기
            먹이 여러개 있으면 상, 좌를 선택
            * */
            dist++;
            if(feed_i < N && feed_j < N){//먹이 존재
                shark_i = feed_i;
                shark_j = feed_j;
                map[shark_i][shark_j] =0;
                shark_eat++;//상어가 먹이 먹음
                if(shark_eat == shark_w){
                    shark_w++;
                    shark_eat =0;
                }
                ans += dist; //먹이한테 가는 거리(시간)
                return true;
            }

        }
        //먹이를 못먹으면 false
        return false;
    }

    static class Point{
        int i,j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }

    }
}
