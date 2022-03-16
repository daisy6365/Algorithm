import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20364_부동산다툼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //땅의 갯수
        int Q = Integer.parseInt(st.nextToken()); //오리의 수

        int[] map = new int[N+1]; //땅갯수 +1 만큼 할당하여, 위치에 따라 땅번호를 알맞게 넣음
        for (int i = 1; i <= Q; i++) {
            //점유하고 싶어하는 땅번호
            int num =Integer.parseInt(br.readLine());

            boolean visited = true;
            int resultNum = 0; //갈수 없음 -> 점유된 땅
            int temp = num;

            while(temp > 0) {
                if(map[temp] != 0) {
                    // 이미 점유된 땅
                    // 갈수 없음
                    resultNum = temp;
                    visited = false;
                }
                temp = temp / 2;
            }

            //점유 할수 있으면
            if(visited) {
                map[num] = i;
                System.out.println(0);
            }
            else{
                System.out.println(resultNum);
            }
        }

    }
}
