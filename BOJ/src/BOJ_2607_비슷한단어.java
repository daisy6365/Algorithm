import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];

        int sum = 0;

        for(int i = 0; i<N; i++){
            arr[i] = br.readLine();
        }

        for(int j = 1; j<N; j++){
            String s1 = arr[0];
            String s2 = arr[j];

            if(s1.length() <  s2.length()){
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }

            char s1Arr[] = s1.toCharArray();
            char s2Arr[] = s2.toCharArray();

            int result = s1Arr.length;

            for(int k = 0; k<s1Arr.length; k++){
                for(int l = 0; l<s2Arr.length; l++){

                    if(s1Arr[k] == s2Arr[l]){
                        result--;
                        s2Arr[l] = ' ';
                        break;
                    }
                }
            }
            if(result <= 1){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
