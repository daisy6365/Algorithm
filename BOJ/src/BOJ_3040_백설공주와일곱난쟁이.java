import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
    static int[] dwarfs;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new int[9];
        isSelected = new boolean[9];

        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        sevenDwarf(0,0);
    }
    static void sevenDwarf(int idx,int start){
        if(idx == 7){
            int dwarfSum=0;
            for (int i = 0; i < dwarfs.length; i++) {
                if(isSelected[i]){
                    dwarfSum += dwarfs[i];
                }
            }
            if(dwarfSum == 100){
                for (int i = 0; i < dwarfs.length; i++) {
                    if(isSelected[i]){
                        System.out.println(dwarfs[i]);
                    }
                }
            }
            return;
        }
        else{
            for (int i = start; i < dwarfs.length; i++) {
                if(!isSelected[i]){
                    isSelected[i] = true;
                    sevenDwarf(idx+1, i+1);
                    isSelected[i] = false;
                }
            }
        }
    }
}
