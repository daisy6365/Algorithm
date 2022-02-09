
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1228_암호문1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc =1; tc<=10;tc++){
            ArrayList<Integer> password = new ArrayList<>(); //변경전 암호

            int first_length = sc.nextInt(); //변경전 암호 길이
            //이전 암호 넣기
            for(int i=0; i<first_length;i++){
                int num = sc.nextInt();
                password.add(num);
            }

            int order_length = sc.nextInt(); // 명령문 갯수
            for(int i =0;i<order_length;i++){
                char input = sc.next().charAt(0);
                int position = sc.nextInt();
                int count = sc.nextInt();
                for(int j=0;j<count;j++){
                    int input_num = sc.nextInt();
                    password.add(position+j,input_num);
                }
            }
            System.out.print("#"+tc+" ");
            for(int i =0; i<10;i++){
                System.out.print(password.get(i)+" ");
            }
            System.out.println();
        }
    }
}
