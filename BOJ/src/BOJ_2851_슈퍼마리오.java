import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851_슈퍼마리오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[10];
        int score = 0;

        for(int i = 0; i<10;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<arr.length;i++){
            if((score+arr[i])<=100){
                score += arr[i];
            }
            else if((100-score) >= ((score+arr[i])-100)){
                score += arr[i];
                break;
            }
            else{break;}
        }
        System.out.println(score);

    }
}
