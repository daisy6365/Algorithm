import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);
        int result = people[0];
        for (int i = 1; i < N; i++) {
            people[i] = people[i-1] + people[i];
            result += people[i];
        }

        System.out.println(result);
    }
}

//public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int [] arr = new int[N];
//        int wait_time =0;
//        int total_time = 0;
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//        for (int i = 0; i < N; i++) {
//            wait_time += arr[i];
//            total_time += wait_time;
//        }
//        System.out.println(total_time);
//    }