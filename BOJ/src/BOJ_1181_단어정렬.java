import java.util.*;
import java.io.*;

public class BOJ_1181_단어정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N ; i++){
            String temp = br.readLine();
            if(!list.contains(temp)){
                list.add(temp);
            }
        }

        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                }
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return -1;
            }
        });

        for(String s : list){
            System.out.println(s);
        }

    }
}

