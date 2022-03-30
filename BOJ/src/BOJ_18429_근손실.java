import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {
    static int N,K; //기간, 근손실량
    static int[] kits;
    static boolean[] isSelected;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0,500);
        System.out.println(count);
    }

    public static void permutation(int idx,int totalWeight){
        if(idx == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!isSelected[i]){
                totalWeight = totalWeight + (kits[i]-K);
                if(totalWeight >= 500){
                    isSelected[i]=true;
                    permutation(idx+1,totalWeight);
                    isSelected[i] = false;
                }
                totalWeight = totalWeight - (kits[i]-K);
            }
        }
    }
}
