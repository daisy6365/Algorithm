package level1;

/*
* 문제를 풀 때, 제한사항을 본다
* 런타임 에러 -> 크기 문제일 수도 있음
* int -> long으로 한다
* Double보다 long이 속도적으로 훨씬 효율적임
* */
public class 크기가작은부분문자열 {
    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
    }
    public static int solution(String t, String p) {
        int answer = 0;

        long p_temp = Long.parseLong(p);
        for (int i = 0; (t.length() - i) >= p.length() ; i++) {
            long t_temp =  Long.parseLong(t.substring(i,i + p.length()));
            if(t_temp <= p_temp){
                answer++;
            }
        }
        return answer;
    }
}
