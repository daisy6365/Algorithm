import java.util.Scanner;

public class BOJ_2442_별찍기5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        char ch = 'A';

        for(int i = 1; i <= num;i++){
            for(int j = i; j<num;j++){
                System.out.printf("  ");
            }
            for(int j = 0; j<(i*2-1);j++){
                System.out.printf("* ");
            }
            System.out.println();
        }
        System.out.println("==========================");

        for(int i = 1; i <= num;i++){
            for(int j = i; j<num;j++){
                System.out.printf("   ");
            }
            for(int j = 0; j<(i*2-1);j++){
                System.out.printf("%2d ",count++);
            }
            System.out.println();
        }
        System.out.println("==========================");

        for(int i = 1; i <= num;i++){
            for(int j = i; j<num;j++){
                System.out.printf("  ");
            }
            for(int j = 0; j<(i*2-1);j++){
                System.out.printf("%c ",ch++);
            }
            System.out.println();
        }
    }
}
