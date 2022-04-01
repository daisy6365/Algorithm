import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기_DFS {
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        dfs(0, X);
        System.out.println(count);
    }
    static void dfs(int idx, int X){
        if(X == 1){
            count = Math.min(idx,count);
            return;
        }
        if(count <= idx) return;

        if(X % 3 == 0) dfs(idx+1, X/3);
        if(X % 2 == 0) dfs(idx+1, X/2);
        dfs(idx+1,X-1);

    }
}
