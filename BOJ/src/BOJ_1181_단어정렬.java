import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(arr.contains(s)){
               continue;
            }
            arr.add(s);
        }

        Collections.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }
                else if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return -1;
            }
        });

        for(int i =0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }
}
