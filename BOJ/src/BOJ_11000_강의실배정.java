import java.io.*;
import java.util.*;

public class BOJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Class> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(list.get(0).end);
        for (int i = 1; i < N; i++) {
            if(list.get(i).start >= priorityQueue.peek()){
                priorityQueue.poll();
            }
            priorityQueue.add(list.get(i).end);
        }
        System.out.println(priorityQueue.size());
    }

    static class Class implements Comparable<Class>{
        int start;
        int end;

        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Class c) {
            if(this.start == c.start){
                return this.end - c.end;
            }
            return this.start - c.start;
        }
    }
}
