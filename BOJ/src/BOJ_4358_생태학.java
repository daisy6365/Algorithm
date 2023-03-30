import java.io.IOException;
import java.util.*;

public class BOJ_4358_생태학 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;

        while(sc.hasNextLine()){
            String temp_s = sc.nextLine();
            if(map.containsKey(temp_s)){
                map.replace(temp_s, map.get(temp_s)+1);
            }
            else{
                map.put(temp_s, 1);
            }
            count++;
        }

        for(String key : map.keySet()) {
            double num = (double)(map.get(key) * 100) / count;

            System.out.println(key + " " + String.format("%.4f", num));
        }
    }
}
