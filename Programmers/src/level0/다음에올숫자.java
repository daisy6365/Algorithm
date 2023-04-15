package level0;

class 다음에올숫자 {
    public int solution(int[] common) {
        int answer = 0;

        int temp = common[1] - common[0];
        if(temp + common[1] != common[2]){
            temp = common[1] / common[0];
            answer = common[common.length - 1] * temp;
        }
        else{
            answer = common[common.length - 1] + temp;
        }


        return answer;
    }
}
