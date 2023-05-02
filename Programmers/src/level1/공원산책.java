package level1;

public class 공원산책 {
    static char[][] map;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int roboti, robotj;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int [2];
        map = new char[park.length][park[0].length()];
        makeMap(park);
        goRobot(routes);

        answer[0] = roboti;
        answer[1] = robotj;

        return answer;
    }
    private static void makeMap(String[] park){
        for(int i = 0; i < map.length ; i++){
            String temp_s = park[i];
            map[i] = temp_s.toCharArray();
            for(int j = 0; j < map[i].length ; j++){
                if(map[i][j] == 'S'){
                    roboti = i;
                    robotj = j;
                }
            }
        }
    }

    private static void goRobot(String[] routes){
        for(int i = 0; i < routes.length ; i++){
            int d = checkDirection(routes[i].charAt(0));
            int count = routes[i].charAt(2) - '0';
            int nowi = roboti;
            int nowj = robotj;
            for(int j = 0; j < count ; j++){
                int nexti = nowi + direction[d][0];
                int nextj = nowj + direction[d][1];

                if(nexti < 0 || nexti >= map.length || nextj < 0 || nextj >= map[nexti].length
                        || map[nexti][nextj] == 'X'){
                    nowi = roboti;
                    nowj = robotj;
                    break;
                }
                else{
                    nowi = nexti;
                    nowj = nextj;
                }
            }
            roboti = nowi;
            robotj = nowj;
        }
    }

    private static int checkDirection(char op){
        if(op == 'N'){
            return 0;
        }
        else if(op == 'S'){
            return 1;
        }
        else if(op == 'W'){
            return 2;
        }
        else {
            return 3;
        }
    }
}
