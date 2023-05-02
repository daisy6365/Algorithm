package level1;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        //최대공약수
        for(int i = 1 ; i <= min ; i++){
            if(n % i == 0 && m % i == 0){
                answer[0] = i;
            }
        }

        //최소공배수
        int result = min;
        int j = 1;
        while(true){
            if(result % n == 0 && result % m == 0){
                answer[1] = result;
                break;
            }
            j++;
            result = min * j;
        }

        return answer;
    }
}
