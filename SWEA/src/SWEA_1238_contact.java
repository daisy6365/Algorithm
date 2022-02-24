import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_contact {
    static int[][] arr;
    static boolean[] visit;
    static int[] visit_time; // dfs는 해당 정점에 방문했어도 다른 경로로 더 빨리 도착하는 경우도 있을수 있어서 시간 기록.
    static int ans;
    static int len, start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = 10;
        for (int tc = 1; tc <= TC; tc++) {
            len = sc.nextInt(); // 간선 데이터의 길이
            start = sc.nextInt(); // 출발점.

            arr = new int[101][101];
            visit = new boolean[101]; // 특정 정점이 이미 연락받았는지 체크

            for (int i = 0; i < len / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                arr[from][to] = 1; // 간선정보
            } // end input
///////////////////////////////////////////////////
//			bfs();
///////////////////////////////////////////////////
            visit_time = new int[101];
            Arrays.fill(visit_time, Integer.MAX_VALUE);
            dfs(start, 0);
            int maxTime=0;
            for(int i=1; i<=100; i++) {
                if(visit_time[i]!=Integer.MAX_VALUE && maxTime<=visit_time[i]) {
                    ans = i;
                    maxTime = visit_time[i];
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true; // 아직 큐에서 안꺼냈지만 큐에 들어간 이상 곧 나올것임. 큐에 또 들어가지 않게 해야함.

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 큐에 있는 연락후보 갯수.(출발점에서 거리가 같은 정점들 갯수)

            int tmp = 0; // 이번에 연락받는 애들 중에 숫자 제일 큰애 찾기.
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                tmp = Math.max(tmp, now); // 이번에 문자받는 애들 중에 숫자 큰거 저장해놓자.
                for (int i = 1; i <= 100; i++) {
                    if (arr[now][i] == 1 && !visit[i]) {
                        queue.add(i);
                        visit[i] = true;
                    }
                }
            }
            // 동시에 연락받는 애들 처리 완료
            ans = tmp; // 방금 연락받은 애들 중에 숫자 제일 큰애가 정답 후보.
        }
    }

    ///////////////////////////////////////////////////////////////////
    static int maxTime;
    static void bfs2() {
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(start, 0));
        visit[start] = true;

        maxTime = 0;
        while (!queue.isEmpty()) {
            Person now = queue.poll();
            if(maxTime < now.time) {
                ans = now.num;
                maxTime = now.time;
            }else if(maxTime == now.time) {
                ans = Math.max(ans, now.num);
            }
            for (int i = 1; i <= 100; i++) {
                if (arr[now.num][i] == 1 && !visit[i]) {
                    queue.add(new Person(i, now.time + 1));
                    visit[i] = true;
                }
            }
        }
    }

    static class Person {
        int num, time;

        Person(int n, int t) {
            num = n; // 학생번호
            time = t; // 연락받은 시간
        }
    }

    ////////////////////////////////////////////////////////////////////
    static void dfs(int now, int time) { // 현재 정점과 연락받는데 걸리는 시간
        if(visit_time[now] <= time) { // 예전에 방문했던 것보다 현재 시간이 같거나 더 오래걸려? 더이상의 재귀 의미없음.
            return;
        }

        visit_time[now] = time;
        for(int i=1; i<=100; i++) {
            if(arr[now][i]==1)
                dfs(i, time+1);
        }
    }
}