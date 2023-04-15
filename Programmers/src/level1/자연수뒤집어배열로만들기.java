package level1;

class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        long num = n;
        int count = 0;
        while(true){
            if(num == 0){break;}
            num /= 10;
            count++;
        }

        int[] answer = new int[count];
        for(int i = 0; i < count ; i++){
            answer[i] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }
}