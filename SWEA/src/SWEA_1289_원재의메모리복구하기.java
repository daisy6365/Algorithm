import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); //테스트 케이스
        //갯수를 세기 위한 count 변수

        //테스트케이스 수만큼 입력 받음
        for(int tc = 1; tc <= TC ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            //입력 받은 문자열 길이만큼 배열 생성
            int [] arr = new int[s.length()];

            //배열안에 문자열 하나씩 넣기
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.charAt(i) -'0';
            }

            //테스트케이스 안에 넣어줘야 count값 갱신됨
            int count =0;
            //배열 탐색 하며, i번째 배열 안에 1인경우 0으로 반환
            // 0인경우 1로 반환하며 카운트 세기
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 1){
                    count++;
                    // i 뒤에 있는 배열값들을 바꾸기 위해 for문 한번 더함
                    // for문 i부터 돔
                    for (int j = i; j < arr.length; j++) {
                        if(arr[j] == 1){
                            arr[j] = 0;
                        }
                        else{
                            arr[j] = 1;
                        }
                    }
                }
                else{continue;}
            }

            System.out.println("#"+tc+" "+ count);
        }

    }
}