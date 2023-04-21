import java.util.*;
import java.io.*;

public class BOJ_20006_랭킹전대기열 {
    static class Player implements Comparable<Player>{
        int level;
        String name;
        boolean isSelected; // 방참가 여부

        public Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o1){
            return this.name.compareTo(o1.name);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] playerList = new Player[p];

        for(int i = 0 ; i < p ; i++){
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            playerList[i] = player;
        }

        for(int i = 0 ; i < p ; i++){
            List<Player> roomList = new ArrayList<>();
            if(!playerList[i].isSelected){
                // 방참가를 안했다면
                for(int j = i; j < p ; j++){
                    // 해당 유저 이후의 사람들 비교
                    if(roomList.size() == m){
                        // 방이 모두 찼다면 종료
                        break;
                    }
                    int level_temp = playerList[j].level;
                    String name_temp = playerList[j].name;
                    boolean isSelected_temp = playerList[j].isSelected;
                    if(!isSelected_temp && level_temp <= (playerList[i].level+10) && level_temp >= (playerList[i].level - 10)){
                        // 방입장 조건이 만족된다면 -> 참가 true, roomList에 추가
                        playerList[j].isSelected = true; //
                        roomList.add(new Player(level_temp, name_temp));
                    }
                }

                // 모두 돌앗다면 ->방 다 채웠는지 확인
                // 채워졌으면 Started! 안채워졌으면 Waiting!
                if(roomList.size() == m){
                    sb.append("Started!").append("\n");
                }
                else{
                    sb.append("Waiting!").append("\n");
                }
                // 정렬후 출력
                Collections.sort(roomList);
                for(Player player : roomList){
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
