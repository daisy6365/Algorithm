package level2;

import java.util.*;

class 리코쳇로봇 {
    static class Point{
        int i, j, depth;
        public Point(int i, int j, int depth){
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }
    static int N,M;
    static char[][] map;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(String[] board) {
        int answer = 0;
        map = new char[board.length][board[0].length()];
        N = map.length;
        M = map[0].length;

        int nowi = 0;
        int nowj = 0;
        for(int i = 0; i < board.length ; i++){
            map[i] = board[i].toCharArray();
            if(board[i].indexOf("R") > 0){
                nowi = i;
                nowj = board[i].indexOf("R");
            }
        }
        answer = bfs(nowi, nowj);
        return answer;
    }

    private static int bfs(int nowi, int nowj){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(nowi, nowj, 0));
        boolean[][] isSelected = new boolean[N][M];
        isSelected[nowi][nowj] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(map[p.i][p.j] == 'G') return p.depth;

            for(int d = 0; d < 4 ;d++){
                int nexti = p.i;
                int nextj = p.j;

                while(true){
                    if(nexti < 0 || nextj < 0 || nexti >= N || nextj >= M) break;
                    if(map[nexti][nextj] == 'D') break;
                    nexti += direction[d][0];
                    nextj += direction[d][1];
                }

                nexti -= direction[d][0];
                nextj -= direction[d][1];


                if(isSelected[nexti][nextj] || (nexti == p.i && nextj == p.j)) continue;
                isSelected[nexti][nextj] = true;
                q.add(new Point(nexti, nextj, p.depth + 1));
            }
        }
        return -1;
    }
}