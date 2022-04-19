import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
    static int di[] = { -1, 1, 0, 0 };
    static int dj[] = { 0, 0, -1, 1 };
    static int N;
    static char[][] map;
    static boolean[] visitedO;

    static ArrayList<Node> teacher = new ArrayList<>();
    static ArrayList<Node> empty = new ArrayList<>();
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T')
                    teacher.add(new Node(i, j));
                if (map[i][j] == 'X')
                    empty.add(new Node(i, j));
            }
        }
        visitedO = new boolean[empty.size()];

        //장애물 3개 설치
        recur(0,0);

        if(flag){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
    static void recur(int count, int idx){
        if(count == 3){
            //3개 다 설치 됐을때
            if (dfs()) {
                //감시 시작
                flag = true;
            }
            return;

        }

        for (int i = idx; i < empty.size(); i++) {
            if(!visitedO[i]){
                //빈자리 X에 장애물설치하기
                visitedO[i] = true;
                Node node = empty.get(i);
                map[node.i][node.j] = 'O';
                recur(count+1,i+1);

                //원상복구
                map[node.i][node.j] = 'X';
                visitedO[i] = false;
            }
        }
    }

    private static boolean dfs() {
        //감시
        for (Node n : teacher) {
            for (int i = 0; i < 4; i++) {
                int nexti = n.i;
                int nextj = n.j;
                while (true) {
                    nexti += di[i];
                    nextj += dj[i];

                    if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N) {
                        break;
                    }

                    if (map[nexti][nextj] == 'S')
                        return false;
                    if (map[nexti][nextj] == 'O')
                        break;
                }
            }
        }
        return true;
    }


    static class Node{
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
