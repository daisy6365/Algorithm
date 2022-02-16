import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //집합 S의 갯수
        int M = Integer.parseInt(st.nextToken()); //주어지는 문자열 갯수 (비교대상)
        int count = 0; //카운트 변수

        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            //비교대상 문자열
            String s = br.readLine();
            if(words.contains(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}
