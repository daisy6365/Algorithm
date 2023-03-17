import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(times);

        // 첫번째 회의 일단 카운트
        int end_time = times.get(0).end;
        int count = 1;
        // 두번째부터 greedy 시작
        for (int i = 1; i < N; i++) {
            if (times.get(i).start >= end_time){
                end_time = times.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }
    static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {
            // 끝나는 시간이 같으면 시작시간으로 정렬해야함 -> 시작시간 정렬도 중요
            if(this.end == time.end){
                return this.start - time.start;
            }
            // 나머지는 다 끝나는 시간으로 정렬
            return this.end - time.end;
        }
    }
}
