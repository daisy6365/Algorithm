package level1;

class 약수의갯수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        while(true){
            // 13, 14, 15, 16, 17
            if(left > right) break;
            int count = 0;
            for(int j = 1 ; j <= left ; j ++){
                if(left % j == 0){
                    count++;
                    System.out.println(count);
                }
            }
            if(count % 2 == 0)answer += left;
            else answer -= left;
            left++;
        }
        return answer;
    }
}