package level2;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        arr[0] = arr[0].toUpperCase();
        for(int i = 0; i < arr.length ; i++){
            if (i+1 == arr.length){
                break;
            }
            else {
                if(arr[i].equals(" ")){
                    arr[i+1] = arr[i+1].toUpperCase();
                }
                else{
                    arr[i+1] = arr[i+1].toLowerCase();
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }
}
