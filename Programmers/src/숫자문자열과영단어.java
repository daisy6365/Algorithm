public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("1zerotwozero3"));

    }
    public static int solution(String s) {
        String[] number_alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < number_alphabet.length ; i++) {
            s = s.replaceAll(number_alphabet[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
