import java.util.Arrays;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        String[] arr1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] arr2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] arr3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        String[] arr4 = {"ac", "ca", "ac", "ac"};
        System.out.println(Arrays.toString(solution(3, arr1)));
        System.out.println(Arrays.toString(solution(5, arr2)));
        System.out.println(Arrays.toString(solution(2, arr3)));
        System.out.println(Arrays.toString(solution(2, arr4)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 탈락한 단어의 위치(번호)
        int result_num = 0;

        flag: for (int i = 1; i < words.length; i++) {
            // 끝말잇기의 첫번째 조건 확인 (전 단어 마지막 철자로 시작하는 단어 인지)
            char pre_char = words[i-1].charAt(words[i-1].length()-1);
            char post_char = words[i].charAt(0);

            if(pre_char != post_char) {
                result_num = i;
                break;
            }

            for (int j = 0; j < i; j++) {
                // 끝말잇기의 두번째 조건 확인 (이전에 나왔던 단어 인지)
                if(words[i].equals(words[j])){
                    result_num = i;
                    break flag;
                }
            }
        }

        if(result_num == 0) {
            return answer;
        }

        // 탈락자 번호 , 탈락한 순서 값 넣기
        result_num++;
        if(result_num % n != 0){
            answer[0] = result_num % n;
            answer[1] = (result_num / n) + 1;
        }
        else{
            answer[0] = n;
            answer[1] = result_num / n;
        }

        return answer;
    }
}
