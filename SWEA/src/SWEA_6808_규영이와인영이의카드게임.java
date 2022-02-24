import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
    static int [] Kcards = new int[9];
    static boolean [] isSelected;
    static int win,same;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int total_case = 9*8*7*6*5*4*3*2;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            // count 초기화
            win = 0;
            same = 0;
            isSelected = new boolean[19];

            for (int i = 0; i < 9; i++) {
                Kcards[i] = Integer.parseInt(st.nextToken());
                //총 18장 카드중에 규영이가 쓰고 있는 카드는 사용중임!
                isSelected[Kcards[i]] = true;
            }

            cardGame(0,0,0);

            System.out.println("#"+tc+" "+win+" "+(total_case-same-win));
        }
    }

    public static void cardGame(int idx,int Kscore, int Iscore){
        //9번 다 비교 했으면
        if(idx == 9){
            //규영이와 인영이의 점수 비교
            if(Kscore>Iscore){
                //규영이 점수가 클때
                win++;}
            if(Kscore == Iscore){
                //서로 같을때(무승부)
                same++;}
            return;
        }

        else{
            for (int i = 1; i < 19; ++i) {
                //규영이가 쓰고 있지않은 카드 -> 인영이가 쓰고있는 카드
                if(!isSelected[i]){
                    isSelected[i] = true;

                    // 규영이가 쓰고있는 카드 숫자 + 1~18(그중 규영이가 쓴 카드는 빼기)까지 더하여(인영이가 가질수 있는 카드)
                    // 이겼을때의 점수를 만듦
                    int score = Kcards[idx] + i;

                    //규영이가 이겼을때
                    if (Kcards[idx] > i) {
                        //규영이한테 점수 부과
                        cardGame(idx + 1, Kscore + score, Iscore);
                    }
                    else {
                        //인영이한테 점수부과
                        cardGame(idx + 1, Kscore, Iscore + score);
                    }
                    isSelected[i] = false;
                }
            }
        }
    }
}
