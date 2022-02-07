import java.util.Scanner;

public class BOJ_10974_모든순열 {
    static int num =0;
    static int N = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        boolean[] selected = new boolean[N];
        permutation(0,selected, new int[num]);
    }
    private static void permutation(int count, boolean[] selected,int[] nums ){
        if(count == num){
            for(int i =0; i<nums.length;i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i =1; i<=num;i++){
            if(selected[i-1] == true){continue;}
            selected[i-1] = true;
            nums[count] = i;
            permutation(count+1, selected,nums);
            selected[i-1] = false;
        }
    }
}
