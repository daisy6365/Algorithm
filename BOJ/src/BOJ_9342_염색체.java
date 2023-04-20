import java.util.*;
import java.io.*;

// 정규표현식 ^[]*$
public class BOJ_9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T ; t++){
            String s = br.readLine();
            if(s.matches("^[A-F]?A+F+C+[A-F]*$")){
                System.out.println("Infected!");
            }
            else{
                System.out.println("Good");
            }
        }
    }
}
