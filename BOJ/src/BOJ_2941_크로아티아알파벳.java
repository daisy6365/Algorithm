import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] alpabetCroatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        int count =0;

        for (int i = 0; i < alpabetCroatia.length; i++) {
            if(s.contains(alpabetCroatia[i])){
                s = s.replace(alpabetCroatia[i],".");
            }
        }

        System.out.println(s.length());
    }
}
