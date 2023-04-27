import java.util.*;
import java.io.*;

public class BOJ_1713_후보추천하기 {
    static class Candidate implements Comparable<Candidate>{
        int num; // 후보번호
        int vote; // 추천수
        int order; // 들어온 순서
        public Candidate(int num, int vote, int order){
            this.num = num;
            this.vote = vote;
            this.order = order;
        }

        @Override
        public int compareTo(Candidate o1) {
            if(this.vote == o1.vote){
                return this.order - o1.order;
            }else if(this.vote < o1.vote){
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사진틀의 갯수
        int R = Integer.parseInt(br.readLine()); // 추천수
        List<Candidate> list = new ArrayList<>();
        int[] students = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < R ; i++){
            int newNum = Integer.parseInt(st.nextToken()); // 새로운 후보
            // 초과라면? 조건 생각해야함
            if(students[newNum] > 0){
                // 똑같은거라면
                for(int j = 0 ; j < list.size(); j++){
                    if(list.get(j).num == newNum){
                        list.get(j).vote += 1;
                        break;
                    }
                }
                students[newNum] += 1;
            }
            else{
                if(list.size() >= N){
                    Collections.sort(list);
                    int getnum = list.get(0).num;
                    list.remove(0);
                    students[getnum] = 0;
                }
                list.add(new Candidate(newNum,1, i));
                students[newNum] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < students.length ; i++){
            if(students[i] > 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
