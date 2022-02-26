import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12927_배수스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] bulb = new char[s.length()+1];
        bulb[0] = '0';
        for (int i = 1; i < bulb.length; i++) {
            bulb[i] = s.charAt(i-1);
        }

        int count =0;
        for (int i = 1; i < bulb.length; i++) {
            if(bulb[i] == 'N') continue;
            for (int j = i; j < bulb.length; j+=i) {
                if(bulb[j] == 'N'){
                    bulb[j] = 'Y';
                }
                else if(bulb[j] == 'Y'){
                    bulb[j] ='N';
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
