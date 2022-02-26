import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //총 인원수
        int K = Integer.parseInt(st.nextToken()); //방안의 최대 수용 인원수

        int [][] students = new int[2][6];//성별 학년
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            //성별 학년
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            //성별, 학년을 구분하여 해당 배열 위치에 ++하여 인원수 세기
            students[gender][grade-1]++;
        }

        //최종 방수
        int result=0;
        //반복문을 돌려 인원수만큼 최대수용인원수를 계산하여 방 세기
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                //최대 수용인원수로 떨어지지않는다면 -> 방이 1개 더 필요하다는 의미
                if(students[i][j]%K != 0){
                    result += 1;
                }
                //인원수 만큼 나눈 값 -> 방수
                result += students[i][j]/K;
            }
        }
        System.out.println(result);
    }
}
