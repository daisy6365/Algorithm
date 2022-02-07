import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class BOJ_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tree_list = new HashMap<>();
        int sum =1;

        String s = br.readLine();
        while (s.length() != 0){
            if(!tree_list.containsKey(s)){
                tree_list.put(s,1);
            }
            else if (tree_list.containsKey(s)){
                tree_list.put(s,tree_list.get(s)+1);
            }
            sum++;
            s = br.readLine();

        }
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(tree_list.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            double per = (tree_list.get(key) * 100.0) / sum;
            sb.append(key + " " + String.format("%.4f", per) + "\n");
        }
        System.out.println(sb);

    }
}
