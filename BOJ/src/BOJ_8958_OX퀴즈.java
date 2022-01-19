import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        String arr[] = new String[TC];

        for(int i = 0; i<TC;i++){

            arr[i] = br.readLine();
        }
        for(int i = 0;i< TC;i++){
            int count=0;
            int sum=0;
            for(int j=0; j<arr[i].length();j++){
                if(arr[i].charAt(j) == 'O'){
                    count++;
                    sum += count;
                }
                else{
                    count = 0;
                }
            }
            System.out.println(sum);
        }
    }
}

