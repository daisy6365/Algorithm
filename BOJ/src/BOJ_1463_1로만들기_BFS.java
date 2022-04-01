import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_1로만들기_BFS {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        ans = Integer.MAX_VALUE;
        bfs(X);
        System.out.println(ans);
    }
    static void bfs(int X){
        Queue<Integer> q = new LinkedList<>();

        //이미들어간 숫자를 다시 넣지 않을 방문변수
        boolean[] isSelected = new boolean[X+1];

        q.add(X);
        isSelected[X] = true;

        int count =0;
        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == 1){
                    ans = count;
                    return;
                }
                if(now % 3 == 0 && !isSelected[now/3]) {
                    q.add(now/3);
                    isSelected[now/3] = true;
                }
                if(now % 2 == 0 && !isSelected[now/2]){
                    q.add(now/2);
                    isSelected[now/2] = true;
                }
                if(!isSelected[now-1]){
                    q.add(now-1);
                    isSelected[now-1] = true;
                }
            }
            count++;
        }
    }
}
