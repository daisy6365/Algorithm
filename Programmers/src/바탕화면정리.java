import java.util.*;

class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, 0, 0}; // x중 최소, y 중 최소, x중 최대, y중 최대
        char[][] arr = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length ; i++){
            arr[i] = wallpaper[i].toCharArray();
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr[i].length; j++){
                if(arr[i][j] == '#'){
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], j+1);
                }
            }
        }


        return answer;
    }
}