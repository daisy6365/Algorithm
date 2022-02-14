import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //집합 S의 갯수
        int M = Integer.parseInt(st.nextToken()); //주어지는 문자열 갯수 (비교대상)
        int count = 0; //카운트 변수

        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        List<String> compareSt = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            compareSt.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(S.get(i).equals(compareSt.get(j))){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
