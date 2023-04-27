import java.util.*;
import java.io.*;

public class BOJ_2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> inMap = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            inMap.put(br.readLine(), i);
        }

        int result = 0;
        for(int i = 0 ; i < N; i++) {
            String s = br.readLine();
            if(i != inMap.get(s)){
                int index = inMap.get(s);
                // 다르다면 -> 추월 했다면
                inMap.replace(s, i);
                for(String key : inMap.keySet()){
                    if(inMap.get(key) <= index && inMap.get(key) >= i){
                        // 같거나 그 이후에 있는 것들 한칸씩 뒤로 밀림
                        inMap.replace(key, inMap.get(key) + 1);
                    }
                }

                result++;
            }
        }

        System.out.println(result);

    }
}
