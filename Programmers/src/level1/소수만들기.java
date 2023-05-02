package level1;

public class 소수만들기 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums)); //[1, 3]
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int temp = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                for(int k = j+1 ; k < nums.length ; k++){
                    temp = nums[i] + nums[j] + nums[k];
                    boolean flag = true;
                    for(int l = 2; l <= (int)Math.sqrt(temp) ; l++ ){
                        if(temp % l == 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        answer++;
                    }
                }
            }

        }

        return answer;
    }
}
