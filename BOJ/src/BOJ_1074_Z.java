import java.util.Scanner;

public class BOJ_1074_Z {
    static int N,r,c; //전체크기, 목적지 좌표(r,c)
    static int count; // 재귀함수가 1X1로 쪼개졌을때 방문순서
    static int ans; // r,c가 몇번째로 방문되는지 저장하는 변수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        visitZ(0,0, (int)Math.pow(2,N),1<<N);
        System.out.println(ans);
    }

    static void visitZ(int si,int sj,int ei,int ej){ //(si,sj)~(ei,ej)
        //시간초과 해결
        if(si>r || ei<=r || sj>c || c>=ej){
            //주어진 영역에 목적지 없음 -> 내 영역 한꺼번에 방문 처리
            count += (ei - si)*(ej - sj);
            return;
        }

        if(ei-si == 1){
            //이미 si ~ ei가 1칸이라 더 못쪼갬
            if(si==r && sj == c){ //문제에서 원하는 목적지
                ans = count;
            }
            count++;
            return; //return 해줘야 재귀함수 중단
        }
        int mi = (si+ei)/2;
        int mj = (sj+ej)/2;

        visitZ(si, sj, mi, mj); // 1
        visitZ(si, mj, mi, ej); // 2
        visitZ(mi, sj, ei, mj); // 3
        visitZ(mi, mj, ei, ej); // 4

    }
}
