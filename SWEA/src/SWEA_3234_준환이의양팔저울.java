import java.util.Scanner;

public class SWEA_3234_준환이의양팔저울 {
    static int N;
    static int[] weight;
    static int ans;
    static boolean[] used;

    static int[] facto; //factorial 계산해서 1!~9! 저장해두기
    static int[] pow; //2의 거듭제곱 계산해두기
    static int totalWeight; // 모든 추의 무게 합한해서 현재 올려두 추 빼고 나머지 보기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();

            weight = new int[N];
            used = new boolean[N];

            facto = new int[N+1];
            pow = new int[N+1];
            facto[0] = facto[1] = pow[0] = 1;
            totalWeight = 0;

            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
                facto[i+1] = facto[i]*(i+1);
                pow[i+1] = pow[i]*2;
                totalWeight += weight[i];
            }
            ans =0;
            perm(0,0,0, totalWeight);
            System.out.println("#"+tc+" "+ans);
        }
    }
    static void perm(int idx, int leftSum, int rightSum, int remain){
        if(rightSum+remain <= leftSum){
            ans += facto[N-idx] * pow[N-idx];
            return;
        }
        if(idx == N){
            ans++;
            return;
        }
        //현재 idx번째 순서로 추를 다 한번씩 나봄
        //왼쪽에 올려놓은 경우 오른쪽 저장
        for (int i = 0; i < N; i++) {
                if(used[i]) continue;
                used[i] = true;
                //i번 추를 왼쪽에 놓고 다음재귀 진행
                perm(idx+1, leftSum+weight[i],rightSum, remain-weight[i]);
                if(rightSum+weight[i] <= leftSum){
                    perm(idx+1,leftSum,rightSum+weight[i], remain-weight[i]);
                }
                used[i] = false;
        }
    }
}
