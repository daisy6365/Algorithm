import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_2577_숫자의개수 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        int result = 1;
        int[] count = new int[10];

        for(int i = 0; i<arr.length;i++){
            Scanner sc = new Scanner(System.in);
            result *= sc.nextInt();
        }

        while (result > 0) {
            count[result % 10]++;
            result /= 10;
        }
        for (int i=0; i < count.length; ++i) {
            System.out.println(count[i]);
        }
    }
}
