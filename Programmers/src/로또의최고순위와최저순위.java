import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2]; //최고순위,최저순위
        int zero_cnt = 0;
        int win_cnt = 0;
        for(int i =0; i< lottos.length;i++){
            if(lottos[i] == 0){
                zero_cnt++;
            }
            else{
                for(int j=0;j< 6;j++){
                    if(lottos[i] == win_nums[j]){
                        win_cnt++;
                        break;
                    }
                }
            }
        }
        if(zero_cnt ==0){
            if(win_cnt >=2 ){
                answer[0] = Math.abs(7-win_cnt);
                answer[1] = Math.abs(7-win_cnt);
            }
            else{
                answer[0] = 6;
                answer[1] = 6;
            }
        }
        else{
            if(win_cnt >= 2){
                answer[0] = Math.abs(7-win_cnt-zero_cnt);
                answer[1] = Math.abs(7-win_cnt);
            }
            else{
                answer[0] = Math.abs(7-win_cnt-zero_cnt);
                answer[1] = 6;
            }
        }
        return answer;
    }
}
