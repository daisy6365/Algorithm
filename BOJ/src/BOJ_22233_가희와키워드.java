import java.util.*;
import java.io.*;

public class BOJ_22233_가희와키워드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            map.put(s, false);
        }

        StringBuilder sb  = new StringBuilder();
        int count = map.size();
        for(int i = 0 ; i < M ; i++){
            String[] arr = br.readLine().split(",");
            for(int j = 0; j < arr.length ; j++){
                if(map.containsKey(arr[j])){
                    // 메모장에 적어놨을때
                    if(!map.get(arr[j])){
                        // 메모장에 들어있는 단어이고 사용하지 않았다면
                        count--;
                        map.replace(arr[j], true);
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
