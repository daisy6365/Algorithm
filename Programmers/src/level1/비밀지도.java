package level1;

public class 비밀지도 {
    public static void main(String[] args) {
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        solution(6, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String arr1_binary = getBinary(n, arr1[i]);
            String arr2_binary = getBinary(n, arr2[i]);

            answer[i] = "";
            for (int j = 0; j < n ; j++) {
                if(arr1_binary.charAt(j) == '0' && arr2_binary.charAt(j) == '0'){
                    answer[i] += " ";
                }
                else {
                    answer[i] += "#";
                }
            }
        }

        return answer;
    }

    private static String getBinary(int n, int num){
        String binary = Integer.toBinaryString(num);
        int len = binary.length();
        // 주어진 n에서 binary길이 차만큼 0을 더해야 자릿수가 같아짐
        for(int i=0; i<n-len; i++) binary = "0" + binary;
        return binary;
    }
}
