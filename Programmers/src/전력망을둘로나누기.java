import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기 {
    static int[][] map;
    static boolean[] isSelected;
    public static void main(String[] args) {
        int tc1 = solution(9, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } });
        System.out.println(tc1);

        int tc2 = solution(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } });
        System.out.println(tc2);

        int tc3 = solution(7, new int[][] { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } });
        System.out.println(tc3);
    }


    public static int solution(int n, int[][] wires) {
        int answer = 100;
        map = new int[n+1][n+1];


        for(int i =0 ; i< wires.length;i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[ wires[i][1]][wires[i][0]] = 1;
        }


        for(int i =0 ; i< wires.length;i++){
            // 전선끊음
            map[wires[i][0]][wires[i][1]] = 0;
            map[wires[i][1]][wires[i][0]] = 0;
            isSelected = new boolean[n+1];


            for(int j = 1; j<=n;j++){
                if(isSelected[j]){
                    break;
                }

                int a = bfs(j);
                int b = n - a;
                answer = Math.min(answer, Math.abs(a-b));
            }
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        return answer;
    }

    static int bfs(int start){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isSelected[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            count++;
            for(int i = 1; i< map.length;i++){
                if(isSelected[i]){
                    //방문했을때
                    continue;
                }
                if(map[now][i] == 0){
                    //간선 없을때
                    continue;
                }
                isSelected[i] = true;
                q.offer(i);
            }
        }
        return count;
    }
}
