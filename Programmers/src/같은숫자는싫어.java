import java.util.Stack;

public class 같은숫자는싫어 {
    public static int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length ; i++) {
            int num = stack.peek();
            if(num != arr[i]){
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length-1 ; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr= {4,4,4,3,3};
        System.out.println(solution(arr));
    }
}
