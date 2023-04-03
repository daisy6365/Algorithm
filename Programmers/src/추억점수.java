import java.util.*;


public class 추억점수 {
    public static void main(String[] args){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(solution(name, yearning, photo))); //[1, 3]
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> hashmap = new HashMap<>();

        for(int i = 0; i < name.length; i++){
            hashmap.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for(int i = 0; i < photo.length; i++){
            for(int j = 0; j < photo[i].length ; j++){
                if(hashmap.containsKey(photo[i][j])){
                    answer[i] += hashmap.get(photo[i][j]);
                }
            }
        }


        return answer;
    }
}
