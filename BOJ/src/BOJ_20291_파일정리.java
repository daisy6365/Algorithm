import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] sSplit = s.split("\\."); //.을 기준으로 끊기

            if (map.containsKey(sSplit[1])) {
                // 해쉬맵에 존재하면 숫자만 바꾸기
                map.replace(sSplit[1], map.get(sSplit[1])+1);
            } else {
                // 존재하지 않으면 넣기
                map.put(sSplit[1], 1);
            }
        }
        List<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);

        for (String key : arr) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
