import java.util.*;
import java.io.*;

public class BOJ_4673_셀프넘버 {
    public static void main(String[] args) throws IOException {
        boolean[] isSelected = new boolean[10001];

        for(int i = 0 ; i < 10001 ; i++){
            int temp = d(i);
            if(d(i) < 10001){
                isSelected[d(i)] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10001 ; i++){
            if(!isSelected[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int d(int num){
        int sum = num;

        while(num != 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
