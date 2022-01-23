import java.util.Scanner;

public class BOJ_2439_별찍기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count=1;
        char ch = 'A';

        for(int i = 1 ; i<=num ;i++){
            for(int j = num-i;j>0;j--){
                System.out.printf("  ");
            }
            for(int j = 0;j<i;j++){
                System.out.printf(" *");
            }
            System.out.println();
        }

        System.out.println("========================");
        for(int i = 1 ; i<=num ;i++){
            for(int j = num-i;j>0;j--){
                System.out.printf("   ");
            }
            for(int j = 0;j<i;j++){
                System.out.printf("%2d ",count++);
            }
            System.out.println();
        }

        System.out.println("========================");
        for(int i = 1 ; i<=num ;i++){
            for(int j = num-i;j>0;j--){
                System.out.printf("  ");
            }
            for(int j = 0;j<i;j++){
                System.out.printf(" %c",ch++);
            }
            System.out.println();
        }
    }
}
