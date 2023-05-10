import java.util.*;
import java.io.*;


public class BOJ_2174_로봇시뮬레이션 {
    static int A, B, N, M; // 가로 세로 로봇 수, 명령수
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N북상 E동우 S남하 W서좌
    static Map<Integer, Robot> robot = new HashMap<>();

    static class Robot{
        int i, j, di;

        public Robot(int i, int j, int di){
            this.i = i;
            this.j = j;
            this.di = di;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B+1][A+1];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            int roboti = Integer.parseInt(st.nextToken());
            int robotj = Integer.parseInt(st.nextToken());
            String robotdi = st.nextToken();
            robot.put(i, new Robot(roboti, robotj, parsingDirection(robotdi)));
            map[robotj][roboti] = i;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            moveRobot(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        System.out.println("OK");
    }

    private static void moveRobot(int robotNum, String kind, int count){
        for(int i = 0 ; i < count ; i++){
            Robot r = robot.get(robotNum);
            if(kind.equals("L")){
                // 왼쪽 방향
                if(r.di == 0){
                    robot.replace(robotNum, new Robot(r.i, r.j, 3));
                }
                else {
                    robot.replace(robotNum, new Robot(r.i, r.j, r.di-1));
                }
            }
            else if(kind.equals("R")){
                // 오른쪽 방향
                if(r.di == 3){
                    robot.replace(robotNum, new Robot(r.i, r.j, 0));
                }
                else {
                    robot.replace(robotNum, new Robot(r.i, r.j, r.di+1));
                }
            }
            else {
                // 땅 지도에 표시한 정보 지움
                map[r.j][r.i] = 0;
                // 앞으로 이동
                int nexti = r.i + direction[r.di][0];
                int nextj = r.j + direction[r.di][1];

                if(nexti < 1 || nexti > A || nextj < 1 || nextj > B){
                    System.out.println("Robot " + robotNum +" crashes into the wall");
                    System.exit(0);
                }
                if(map[nextj][nexti] != 0){
                    System.out.println("Robot " + robotNum +" crashes into robot " + map[nextj][nexti]);
                    System.exit(0);
                }
                robot.replace(robotNum, new Robot(nexti, nextj, r.di));
                map[nextj][nexti] = robotNum;
            }
        }
    }

    private static int parsingDirection(String di){
        if(di.equals("N")){
            return 0;
        }
        else if(di.equals("E")){
            return 1;
        }
        else if(di.equals("S")){
            return 2;
        }
        else {
            return 3;
        }
    }
}
