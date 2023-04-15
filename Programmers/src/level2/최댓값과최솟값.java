package level2;

class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";

        String[] s_arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < s_arr.length; i++){
            max = Math.max(max, Integer.parseInt(s_arr[i]));
            min = Math.min(min, Integer.parseInt(s_arr[i]));
        }
        answer = min + " " + max;

        return answer;
    }
}