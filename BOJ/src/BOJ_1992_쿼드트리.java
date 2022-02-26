import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
    static char[][] map;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        } // end input

        sb = new StringBuilder();
        func(0,0,N); // 0,0부터 N크기의 사각형을 압축해!
        System.out.println(sb);
    }

    static void func(int si, int sj, int size) {
        // 0또는1로 채워져있네?! 압축완료! 괄호필요음슴.
        if(checkFill(si, sj, size)) {
            sb.append(map[si][sj]);
            return;
        }

        // 0이랑1이 섞여있네 ? 괄호묶어야겠다 ..
        sb.append("(");
        int mi = si+(size/2);
        int mj = sj+(size/2);
        func(si,sj,size/2); // 1
        func(si,mj,size/2); // 2
        func(mi,sj,size/2); // 3
        func(mi,mj,size/2); // 4
        sb.append(")");
    }

    static boolean checkFill(int si, int sj, int size) {
        for(int i=si; i<si+size; i++) {
            for(int j=sj; j<sj+size; j++) {
                if(map[i][j] != map[si][sj]) {
                    return false;
                }
            }
        }
        return true;
    }
}
