import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
    static int N;
    static int[] parents;
    //단위 집합 생성
    public static void makeSet(){
        // 자신의 부모노드를 자신의 값으로 세팅
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
    //a의 집합 찾기(대표자 찾기)
    public static int findSet(int a){
        if(a==parents[a]) return a;
        //루트노드의 값으 나의 부모로 대체
        return parents[a] = findSet(parents[a]);
    }

    //a, b 두집합 합치기
    public static void union(int a, int b){
        //합쳐졌다면 true 합칠 필요가 없다면 false
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return;

        //a 뒤에 b 붙임 -> b의 루트가 a의 루트
        parents[bRoot] = aRoot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); //연산의 갯수

            sb.append("#").append(tc).append(" ");

            parents = new int[N+1];
            makeSet();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int cal = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(cal == 0){
                    //합집합
                    union(a,b);
                }
                else{
                    if (findSet(a) == findSet(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
