import java.util.Scanner;

public class BOJ_2438_별찍기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        char ch = 'A';

        for(int i =0;i<num;i++){
            for(int j =0;j<=i;j++){
                System.out.printf("* ");
            }
            System.out.println();
        }
        System.out.println("============================");
        for(int i =0;i<num;i++){
            for(int j =0;j<=i;j++){
                System.out.printf("%3d",count++);
            }
            System.out.println();
        }

        System.out.println("============================");
        for(int i =0;i<num;i++){
            for(int j =0;j<=i;j++){
                System.out.printf("%c ",ch++);
            }
            System.out.println();
        }

    }
}
