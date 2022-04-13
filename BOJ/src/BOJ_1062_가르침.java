import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
    static int N,K;
    static boolean[] isSelected;
    static String[] alphabet;
    static int maxCount = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alphabet = new String[N];
        isSelected = new boolean[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = s.replace("anta","");
            s = s.replace("tica","");
            alphabet[i] = s;
        }
        //anta tica 부분 방문 처리
        isSelected['a' - 'a'] = true;
        isSelected['n' - 'a'] = true;
        isSelected['t' - 'a'] = true;
        isSelected['i' - 'a'] = true;
        isSelected['c' - 'a'] = true;

        //Krk antic갯수 5개보다 작으면 쓰레기값나옴
        if(K < 5){
            System.out.println(0);
            return;
        }

        rec(0,0);
        System.out.println(maxCount);
    }
    static void rec(int idx, int kCount){
        if((K-5) == kCount){
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;

                for (int j = 0; j < alphabet[i].length(); j++) {
                    if (!isSelected[alphabet[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
            maxCount = Math.max(maxCount, count);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if(isSelected[i] == false) {
                isSelected[i] = true;
                rec(i, kCount + 1);
                isSelected[i] = false;
            }
        }

    }
}
