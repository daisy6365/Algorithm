
public class K진수에서소수개수구하기 {
    public static void main(String[] args){
        System.out.println(solution(437674, 3)); //[1, 3]
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String temp_s = "";
        // K진수 구하기
        temp_s = Integer.toString(n ,k);

        String[] narr_temp = temp_s.split("0");
        // 1이 아닌지 확인 소수 판별
        for(int i = 0; i < narr_temp.length ; i++){
            if(!narr_temp[i].equals("")){
                long number = Long.parseLong(narr_temp[i]);
                if(number != 1){
                    boolean flag = true;
                    for(int j = 2; j <= (int)Math.sqrt(number); j++){
                        if(number % j == 0){
                            flag = false;
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
