import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc =1; tc<=10; tc++){
            int TC = sc.nextInt();
            Queue<Integer> num_queue = new LinkedList<>();

            for(int i =0 ; i<8 ; i++){
                int num = sc.nextInt();
                num_queue.offer(num);
            }

            int x = 1;
            while(x != 0){
                for(int i =1 ; i<=5 ; i++){
                    x = num_queue.poll();
                    x = x-i;
                    if(x < 0){
                        x = 0;
                    }
                    num_queue.offer(x);
                    if(x == 0){
                        break;
                    }
                }
            }

            System.out.print("#"+tc+" ");
            for(int i=0; i<8;i++){
                System.out.print(num_queue.poll()+" ");
            }
            System.out.println();
        }
    }
}
