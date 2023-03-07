import java.util.*;

public class 기능개발 {
    public static void main(String[] args){
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses1, speeds1))); // 2, 1

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses2, speeds2))); // 1, 3, 2

        int[] progresses3 = {93, 30, 55, 60, 40, 65};
        int[] speeds3 = {1, 30, 5, 10, 60, 7};
        System.out.println(Arrays.toString(solution(progresses3, speeds3))); // 2,4
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));

        }

        while(true){
            if(queue.isEmpty()) break;
            System.out.println(queue);
            int day = queue.poll(); // 비교할 대상의 기능마다 남아있는 날짜
            int count = 1;

            // 큐가 안비어있는 상태 -> 현재 기능의 남은 날짜 >=
            while (!queue.isEmpty() && day >= queue.peek()) {
                count++;
                queue.poll(); // 확인한거 버리기
            }
            answer.add(count);
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
