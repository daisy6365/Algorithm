public class 피로도 {
    static boolean[] isSelected;
    static int answer;
    public static void main(String[] args) {
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        System.out.println(solution(80, dungeons));
    }
    public static int solution(int k, int[][] dungeons) {
        answer = -1;
        isSelected = new boolean[dungeons.length];

        backtracking(0, dungeons, k);
        return answer;
    }

    public static void backtracking(int index, int[][] dungeons, int k){
        for(int i = 0; i < dungeons.length ; i++){
            if(!isSelected[i] && k >= dungeons[i][0] ){
                isSelected[i] = true;
                backtracking(index+1,  dungeons, k-dungeons[i][1]);
                isSelected[i] = false;
            }
        }

        answer = Math.max(answer, index);
    }

}
