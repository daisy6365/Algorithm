import java.util.Scanner;

public class BOJ_14891_톱니바퀴 {
    static int[][] gear;
    static int[] rotation;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gear = new int[5][8];

        for (int i = 1; i < 5; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                // N == 0, S == 1
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            // 회전 정보
            int gear_num = sc.nextInt(); // 회전시킬 톱니바퀴 번호
            int rotation_di = sc.nextInt(); // 회전 방향 -> 1 == 시계, -1 == 반시계
            // 회전할때마다 회전정보 배열 초기화
            rotation = new int[5];
            rotation[gear_num] = rotation_di;
            // 회전 방향 확인하기
            checkRotation(gear_num);
            // 값 회전하기
            goRotation();

        }

        System.out.println(calScore());

    }
    private static void checkRotation(int gear_num){
        // 바퀴번호에 맞는 배열을 회전방향으로 회전시킴
        // [1][2]-[2][6] [2][2]-[3][6] [3][2]-[4][6] 각각 값이 같으면 다음거 회전 X , 다르면 다음 거 반대방향으로 회전

        // 왼쪽 확인
        for (int i = gear_num - 1; i > 0 ; i--) {
            if(gear[i][2] != gear[i+1][6]){
                // 값이 다름 회전 방향 반대
                rotation[i] = rotation[i+1] * -1;
            }
            else{
                // 값이 같음 회전하지마
                break;
            }
        }

        // 오른쪽 확인
        for (int i = gear_num + 1; i < 5 ; i++) {
            if(gear[i][6] != gear[i-1][2]){
                rotation[i] = rotation[i-1] * -1;
            }
            else {
                break;
            }
        }
    }

    private static void goRotation(){
        // [0] [7] 양끝은 방향에 따라 각자 [7] [0]으로 가야함
        for (int i = 1; i < 5; i++) {
            if(rotation[i] == 1){
                // 시계방향일 때
                // gear[i][0] = gear[i][7]
                int temp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = temp;
            }
            else if(rotation[i] == -1){
                // 반시계방향일 때
                // gear[i][7] = gear[i][0]
                int temp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j+1];
                }
                gear[i][7] = temp;
            }
        }
    }

    // 12시 방향 점수 계산
    private static int calScore(){
        int sum = 0;
        for (int i = 1; i < 5; i++) {
            if(gear[i][0] == 1){
                sum += Math.pow(2, i-1);
            }
        }
        return sum;
    }
}
