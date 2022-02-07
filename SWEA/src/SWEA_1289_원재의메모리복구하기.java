import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

        for(int tc = 1; tc <= TC; tc++){
            String s = sc.next();
            int [] list = new int[s.length()];

            for(int i = 0 ; i < s.length();i++){
                list[i] = s.charAt(i) - '0';
            }

            int count = 0;
            for(int i =0; i< list.length ; i++){
                if(list[i] == 1){
                    count++;
                    for(int j =i; j<list.length;j++){
                        if(list[j] == 1){
                            list[j] = 0;
                        }
                        else{
                            list[j] = 1;
                        }
                    }
                }
                else{continue;}
            }

            System.out.println("#"+tc+" "+ count);
		}

    }
}