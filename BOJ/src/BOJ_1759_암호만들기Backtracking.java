import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기Backtracking {
    static int L,C;
    static char[] alpabet;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpabet = new char[C];
        isSelected = new boolean[C];

        st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < C; i++) {
            alpabet[i] = (st.nextToken()).charAt(0);
        }
        Arrays.sort(alpabet);
        combination(0,0);
    }

    public static void combination(int cnt, int start) {
        if(cnt == L) { //[L]까지 다 채웠다면
            StringBuilder sb = new StringBuilder();
            int countA =0; //모음
            int countB = 0; //자음
            for (int i = 0; i < C; i++) {
                if(isSelected[i]) {
                    sb.append(alpabet[i]);
                    if(alpabet[i]== 'a' || alpabet[i]=='e' || alpabet[i]=='i' || alpabet[i]=='o' || alpabet[i]=='u') {
                        countA++;
                    }
                    else {
                        countB++;
                    }
                }
            }
            if(countA >= 1 && countB >= 2){
                System.out.println(sb);
            }
            return;
        }
        // 순서없이 고르기 때문에 다음 루프때는 현재+1부터만 조회하면 됨

        for(int i=start; i<C; i++) {
            isSelected[i] = true;
            combination(cnt+1, i+1);
            isSelected[i] = false;
        }
    }
}
