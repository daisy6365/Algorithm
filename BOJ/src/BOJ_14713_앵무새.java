import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14713_앵무새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 앵무새가 말한걸 큐형태로 넣음
        ArrayList<Queue<String>> parrot_array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp_s = br.readLine();
            String[] temp_array = temp_s.split(" ");
            // 1앵무 1큐
            Queue<String> queue = new LinkedList<>();

            for (int j = 0; j < temp_array.length; j++) {
                queue.offer(temp_array[j]);
            }
            // 앵무갯수 == 리스트 크기
            parrot_array.add(queue);
        }

        String sentence = br.readLine();
        String[] sentence_array = sentence.split(" ");

        // 총 결과
        boolean result = true;
        for (int i = 0; i < sentence_array.length; i++) {
            // 비웠는지 확인할 변수
            boolean flag = false;
            String temp_word = sentence_array[i];

            for (Queue q : parrot_array) {
                // 앵무가 내뱉은 단어인지 탐색
                if(!q.isEmpty()){
                    // 큐 존재 확인 필수
                    if(temp_word.equals(q.peek())){
                        // 내뱉은 단어임
                        // 아예 꺼내서 순서대로 뽑을수 있게함
                        q.poll();
                        flag = true;
                    }
                }
            }

            // 못비웠으면
            if(!flag){
                // 앵무가 말한 단어 자체가 아님 -> 아예 Impossible
                result = false;
                break;
            }
        }

        // 큐 다 비웠는지 확인
        long count = parrot_array.stream().filter(Queue::isEmpty).count();
//        System.out.println(parrot_array.size());
        if(parrot_array.size() == count && result){
            // 큐도 다 비웠고, 앵무가 말한 단어라면
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
    }
}
