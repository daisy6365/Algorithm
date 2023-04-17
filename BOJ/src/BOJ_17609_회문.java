import java.util.*;
import java.io.*;


public class BOJ_17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            char[] arrS = s.toCharArray();
            int left = 0;
            int right = arrS.length - 1;

            if(checkPalindrome(arrS, left, right)){
                System.out.println(0);
                continue;
            }
            if(checkPresudoPalindrome(arrS, left, right)){
                System.out.println(1);
            }
            else{
                System.out.println(2);
            }


        }

    }
    private static boolean checkPalindrome(char[] arr , int left, int right){
        while(left <= right){
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkPresudoPalindrome(char[] arr , int left, int right){
        while(left <= right) {
            if(arr[left] != arr[right]) {
                boolean a=checkPalindrome(arr,left+1,right);
                boolean b=checkPalindrome(arr, left,right-1);
                if(!a && !b) {
                    return false;
                }
                else return true;
            }
            left++;
            right--;
        }

        return true;
    }
}
