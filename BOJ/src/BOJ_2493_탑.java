import java.util.Scanner;
import java.util.Stack;

public class BOJ_2493_탑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> top = new Stack<>();
        for(int i = 0;i<N;i++) {
            top.push(sc.nextInt());
        }
        int [] count_list = new int[N];
        int right_top;
        int left_top;
        while(top.size()!=1){
            int i = 0;
            right_top = top.pop();
            left_top = top.peek();

            if(left_top >= right_top){
                count_list[i]++;
                i++;
            }
            else{i++;continue;}

        }
        for(int i = 0;i<N;i++) {
            System.out.println(count_list[i]);
        }
    }
}
