import java.util.*;
import java.io.*;

public class BOJ_16234_인구이동 {
    static int N,L,R;
    static int[][] map;
    static boolean[][] isSelected;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    static ArrayList<Point> moveList;

    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(checkBfs());
    }

    private static int checkBfs(){
        int count = 0;
        while(true){
            boolean flag = false;
            isSelected = new boolean[N][N]; // 인구이동 한턴 돌때마다 초기화
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!isSelected[i][j]){
                        int total = checkCondition(i, j);
                        if(moveList.size() > 1){
                            // 국경열린게 2개 이상일 때 -> 인구이동
                            int peopleNum = total / moveList.size(); // 이동할 인구수 결과
                            movePeople(peopleNum);
                            flag = true;
                        }
                    }
                }
            }
            // 다 돌았는데도 조건 만족할수 없음 -> 0
            if(!flag) return count;
            count++;
        }
    }

    private static int checkCondition(int nowi, int nowj){
        Queue<Point> q = new LinkedList<>();
        moveList = new ArrayList<>();

        q.offer(new Point(nowi, nowj));
        moveList.add(new Point(nowi, nowj));
        isSelected[nowi][nowj] = true;
        int total = map[nowi][nowj];

        while(!q.isEmpty()){

            Point p = q.poll(); // 현재
            for(int d = 0; d < 4 ; d++){
                // 다음꺼
                int nexti = p.i + direction[d][0];
                int nextj = p.j + direction[d][1];

                if(nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !isSelected[nexti][nextj]){
                    int subValue = Math.abs(map[p.i][p.j] - map[nexti][nextj]);
                    if(subValue >= L && subValue <= R){ // 조건 만족
                        q.offer(new Point(nexti, nextj)); // 한턴 다 돌때까지 그다음꺼 확인
                        moveList.add(new Point(nexti, nextj)); // 이동해야할거 넣기
                        total += map[nexti][nextj];
                        isSelected[nexti][nextj] = true;
                    }
                }

            }
        }
        return total;
    }

    private static void movePeople(int peopleNum){
        for(Point p : moveList){
            map[p.i][p.j] = peopleNum;
        }
    }
}
