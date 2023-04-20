import java.util.*;
import java.io.*;


public class BOJ_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N-1];
        long[] cities = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1 ; i++){
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            cities[i] = Long.parseLong(st.nextToken());
        }

        long city = cities[0];
        long result = cities[0] * road[0];
        for(int i = 1 ; i < N-1 ; i++){
            city = Math.min(city, cities[i]);
            result += city * road[i];
        }

        System.out.println(result);
    }
}
