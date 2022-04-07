import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
    static int N,M;
    static char[][] map;
    static boolean[][][] visit;
    static Queue<Point> queue;

    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};

    static class Point{
        int i,j;
        int key;

        Point(int i, int j, int key){
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];

        queue = new LinkedList<>();
        visit = new boolean[N][M][64]; // 0 : 000000 ~ 63 : 111111
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '0'){
                    queue.add(new Point(i,j,0));
                    map[i][j] = '.';
                    visit[i][j][0] = true;
                }
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                if(map[now.i][now.j] == '1'){
                    return dist;
                }
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti<0 || nexti>= N || nextj<0 || nextj >=M || map[nexti][nextj] == '#') continue;

                    if(!visit[nexti][nextj][now.key]){
                        if(map[nexti][nextj] >= 'a' && map[nexti][nextj] <= 'f'){
                            int newKey = (1<<map[nexti][nextj]-'a');
                            int addedKey = now.key | newKey;
                            queue.add(new Point(nexti, nextj, addedKey));
                            visit[nexti][nextj][addedKey] = true;
                        }
                        else if (map[nexti][nextj] >= 'A' && map[nexti][nextj] <= 'F' &&
                                (now.key&(1<<(map[nexti][nextj]-'A')))!=0) { // 옆칸에 문이 있는 경우(키점검)
                            queue.add(new Point(nexti, nextj, now.key));
                            visit[nexti][nextj][now.key] = true;
                        }
                        else if (map[nexti][nextj]=='.' || map[nexti][nextj]=='1') {
                            queue.add(new Point(nexti, nextj, now.key));
                            visit[nexti][nextj][now.key] = true;
                        }
                    }
                }
            }
            dist++;
        }

        //탈출할 수 없으면 -1
        return -1;
    }
}
