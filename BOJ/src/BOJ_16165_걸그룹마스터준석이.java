import java.util.*;
import java.io.*;

public class BOJ_16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine(); // 그룹 명
            int number = Integer.parseInt(br.readLine()); // 그룹 인원 수
            for(int j  = 0 ; j < number ; j++){
                String name = br.readLine(); // 사람 이름
                map.put(name, s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            String s = br.readLine(); // 문제
            int pro = Integer.parseInt(br.readLine()); // 문제 종류

            if(pro == 0){
                // s 그룹에 해당되는 사람 이름 다 출력
                List<String> list = new ArrayList<>();
                for(String key : map.keySet()){
                    if(map.get(key).equals(s)){
                        list.add(key);
                    }
                }

                list.sort(Comparator.naturalOrder());
                for(String temp : list){
                    sb.append(temp).append("\n");
                }

            }
            else{
                // s 사람의 그룹명 출력
                sb.append(map.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
