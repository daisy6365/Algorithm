import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
    static int [][] paper;
    static int [] countNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        countNum = new int[3]; // -1, 0, 1

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0,0,N); // 0,0 ~ N

        for (int i = 0; i < 3; i++) {
            System.out.println(countNum[i]);
        }
    }

    static void func(int si, int sj, int size) {
        // 전체 다 채워짐 -> 압축
        if(check(si, sj, size)) {
            if(paper[si][sj] == -1) countNum[0]++;
            else if(paper[si][sj] == 0) countNum[1]++;
            else countNum[2]++;
            return;
        }

        /*
        *[0,0][0,1][0,2]
        *[1,0][1,1][1,2]
        *[2,0][2,1][2,2]
        * */
        int mid = size/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(si+(mid*i), sj+(mid*j), mid);
            }
        }
    }

    static boolean check(int si, int sj, int size) {
        //같은지 확인
        for(int i=si; i<si+size; i++) {
            for(int j=sj; j<sj+size; j++) {
                if(paper[i][j] != paper[si][sj]) {
                    return false;
                }
            }
        }
        return true;
    }
}
