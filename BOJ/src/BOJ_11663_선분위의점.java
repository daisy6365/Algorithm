import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11663_선분위의점 {
    static int count = 0;
    static int line[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] compareSpot = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            compareSpot[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            count =0;
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            line = new int[end-start+1];
            for (int j = 0; j < line.length; j++) {
                line[j] = start++;
            }
            for (int j = 0; j < N; j++) {
                binarySearch(0, line.length-1, compareSpot[j]);
            }
            System.out.println(count);
        }

    }
    public static void binarySearch(int start, int end, int spotNum){
        if(start > end){
            return;
        }
        int mid = (start+end)/2;
        if(line[mid] < spotNum) binarySearch(mid+1,end,spotNum);
        if(line[mid] > spotNum) binarySearch(start,mid-1,spotNum);
        if(line[mid] == spotNum) {count++; return;}
    }
}
