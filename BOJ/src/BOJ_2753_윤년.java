import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2753_윤년 {
    public static void main(String[] args) throws IOException {
        //윤년 : 4의 배수 -> 100배수가 아닐 때 || 400배수 일 때
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        boolean flag = false;

        if(year%4 == 0) {
            if( year%100 != 0 || year%400 == 0 ){
                flag = true;
            }
            else flag= false;
        }
        else{ flag = false; }

        if(flag) {System.out.println(1);}
        else{System.out.println(0);}
    }
}
