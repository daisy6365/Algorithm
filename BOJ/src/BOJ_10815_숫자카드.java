import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
    static int N,M;
    static int cardsN[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cardsN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            cardsN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cardsN);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(0,N-1,num);
        }

    }
    public static void binarySearch(int start, int end, int cardNum){
        if(start > end){
            System.out.print(0+" ");
            return;
        }
        int mid = (start+end)/2;
        if(cardsN[mid] < cardNum) binarySearch(mid+1,end,cardNum);
        if(cardsN[mid] > cardNum) binarySearch(start,mid-1,cardNum);
        if(cardsN[mid] == cardNum) {System.out.print(1+" "); return;}
    }
}
