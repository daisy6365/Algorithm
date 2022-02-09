import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = 10;
        char[][] bracket = {{'[',']'},{'{','}'},{'(',')'},{'<','>'}};

        for(int tc = 1; tc <= TC;tc++){
            int char_num = sc.nextInt();
            String string = sc.next();


            Stack<Character> stack = new Stack<>();
            int result = 1;
            top:for(int i=0; i<char_num;i++){
                for(int j = 0; j<4;j++){
                    if(string.charAt(i) == bracket[j][0]){
                        stack.push(string.charAt(i));
                        break;
                    }
                    else if(string.charAt(i) == bracket[j][1]){
                        if(stack.pop() != bracket[j][0]){
                            //짝이 맞다면 유효
                            result = 0;
                            break top;
                        }
                    }
                }
            }
            if(!stack.isEmpty()){
                result = 0;
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}
