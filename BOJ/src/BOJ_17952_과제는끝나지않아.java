import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952_과제는끝나지않아 {
    static int answer_score = 0;// 최종 받는 점수
    static Stack<Assignment> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken()); // 과제가 있음(1), 없음(0)
            if(check == 0) {
                // 새로운 과제 X
                // 원래 하던게 있으면 해야함
                // 스택에 넣어놨던거 빼기
                if(!stack.isEmpty()){
                    Assignment oldAssignment = stack.pop();
                    doAssignment(oldAssignment);
                }
            }
            else{
                // 새로운 과제 O
                // 새로 들어온 과제 해야함
                int score = Integer.parseInt(st.nextToken()); // 해당과제의 점수
                int time = Integer.parseInt(st.nextToken()); // 과제의 소요시간
                Assignment newAssignment = new Assignment(score, time);
                doAssignment(newAssignment);
            }

        }
        System.out.println(answer_score);

    }

    private static void doAssignment(Assignment assignment){
        assignment.time--;
        if(assignment.time == 0){
            // 시간 뺀 순간 과제 다 했으면
            // 점수 계산
            answer_score += assignment.score;
        }
        else {
            // 과제 다 못했으면
            // stack에 다시 넣기
            stack.push(assignment);
        }
    }

    static class Assignment{
        int score,time;
        public Assignment(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
