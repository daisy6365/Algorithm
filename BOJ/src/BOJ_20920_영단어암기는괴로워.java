import java.util.*;
import java.io.*;
import java.util.*;

public class BOJ_20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N ; i++){
            String s = br.readLine();
            if(s.length() >= M){
                int temp = map.getOrDefault(s, 0);
                map.put(s, temp + 1);
            }
        }

        // 이미 자주 나오는 단어를 기준으로 정렬됨
        list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) ->{
           int i1 = map.get(o1);
           int i2 = map.get(o2);
           // 자주나온 횟수가 같다면
           if(i1 == i2){
               if(o1.length() == o2.length()){
                   return o1.compareTo(o2);
               }
               return o2.length() - o1.length();
           }
           return i2 - i1;
        });

        StringBuilder sb = new StringBuilder();
        for(String temp_s : list){
            sb.append(temp_s).append("\n");
        }

        System.out.println(sb);
    }
}
