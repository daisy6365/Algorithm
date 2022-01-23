import java.util.Scanner;

public class BOJ_2441_별찍기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;
        char ch = 'A';

        for(int i=num;i>0;i--){
            for(int j=0;j<(num-i);j++){
                System.out.printf("  ");
            }
            for(int j = i;j>0;j--){
                System.out.printf(" *");
            }
            System.out.println();
        }
        System.out.println("==========================");

        for(int i=num;i>0;i--){
            for(int j=0;j<(num-i);j++){
                System.out.printf("   ");
            }
            for(int j = i;j>0;j--){
                System.out.printf(" %2d",count++);
            }
            System.out.println();
        }
        System.out.println("==========================");

        for(int i=num;i>0;i--){
            for(int j=0;j<(num-i);j++){
                System.out.printf("  ");
            }
            for(int j = i;j>0;j--){
                System.out.printf(" %c",ch++);
            }
            System.out.println();
        }
    }
}
