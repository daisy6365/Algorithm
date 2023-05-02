package level1;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;
        int num = 0;
        int y = x;
        while(true){
            if(x == 0){
                break;
            }
            num += (x % 10);
            x /= 10;
        }
        answer = (y % num != 0) ? false : true;
        return answer;
    }
}
