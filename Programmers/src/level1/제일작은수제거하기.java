package level1;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1){
            answer = new int [1];
            answer[0] = -1;
        }
        else{
            answer = new int[arr.length-1];
            int temp = arr[0];
            for(int i = 1 ; i < arr.length ; i++){
                if(temp > arr[i]){
                    temp = arr[i];
                }
            }
            int count = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] != temp){
                    answer[count] = arr[i];
                    count++;
                }
            }
        }
        return answer;
    }
}
