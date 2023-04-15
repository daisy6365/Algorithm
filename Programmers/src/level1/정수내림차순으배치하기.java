package level1;

class 정수내림차순으배치하기 {
    public long solution(long n) {
        String answer = "";
        String m = Long.toString(n);
        int[] arr = new int[m.length()];

        // n쪼개서 넣기
        for(int i = 0; i< m.length(); i++){
            arr[i] = Integer.parseInt(m.substring(i,i+1));
        }

        // 정렬
        for(int i =1; i< m.length(); i++){
            for(int j = 0; j<m.length()-i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // answer에 답 넣기
        for(int i = 0; i<arr.length; i++){
            answer += arr[i];
        }

        return Long.parseLong(answer);
    }
}