import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Tower> towers = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;i++){
            //지금 들어오는 탑의 정보
            Tower now_t = new Tower(i, Integer.parseInt(st.nextToken()));

            while(!towers.isEmpty()&& towers.peek().height < now_t.height ){
                //탑(스택)이 비어있거나 지금 들어오는 탑보다 이전에 있는탑이 작을때
                //탑(스택)이 있다면 현재 탑보다 낮은 애들은 다 버림
                towers.pop();

            }
            if(towers.isEmpty()){
                //다 비었을때 -> 아무도 현재탑의 레이저를 못받음
                sb.append("0 ");
            }
            else {
                //키큰 탑만 남았을때
                sb.append(towers.peek().num + " ");
            }
            //현재탑 입장
            towers.push(now_t);
        }
        System.out.println(sb.toString());
    }

    static class Tower{
        int num,height;
        Tower(int num, int height){
            this.num = num;
            this.height = height;
        }
    }
}