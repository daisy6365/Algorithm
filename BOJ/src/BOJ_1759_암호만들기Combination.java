import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기Combination {
    static int L,C;
    static char[] alpabet;
    static char[] password;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpabet = new char[C];
        password = new char[L];

        st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < C; i++) {
            alpabet[i] = (st.nextToken()).charAt(0);
        }
        Arrays.sort(alpabet);
        combination(0,0);
    }

    public static void combination(int cnt, int start) {
        if(cnt == L) { //password[L]까지 다 채웠다면
            int countA =0; //모음
            int countB = 0; //자음
            for (int i = 0; i < L; i++) {
                if(password[i]== 'a' || password[i]=='e' || password[i]=='i' || password[i]=='o' || password[i]=='u') {
                    countA++;
                }
                else {
                    countB++;
                }
            }
            if(countA >= 1 && countB >= 2){
                for (int i = 0; i < L; i++) {
                    System.out.print(password[i]);
                }
                System.out.println();
            }
            return;
        }
        // 순서없이 고르기 때문에 다음 루프때는 현재+1부터만 조회하면 됨
        for(int i=start; i<C; i++) {
            password[cnt] = alpabet[i];
            combination(cnt+1, i+1);
        }
    }
}
