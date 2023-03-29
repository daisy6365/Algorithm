import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] strings = s.split("\\-");

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split("\\+");
            int sum = 0;

            for (int j = 0; j < split.length; j++) {
                sum += Integer.parseInt(split[j]);
            }


            if (result == Integer.MAX_VALUE) {
                result = sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
