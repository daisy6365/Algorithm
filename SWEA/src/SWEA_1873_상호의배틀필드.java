import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc= 1; tc<=TC;tc++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            char[][] field = new char[r][c];
            int x = 0;
            int y = 0;

            //필드에 집어넣기
            for(int i =0 ;i<r ;i++){
                String str = sc.next();
                for(int j=0 ;j<c ;j++){
                    field[i][j] = str.charAt(j);
                    if(str.charAt(j) == '^' || str.charAt(j) == 'v'||str.charAt(j) == '<'||str.charAt(j) == '>') {
                        x = i;
                        y = j;
                    }
                }
            }

            //명령어 집어넣기
            int num = sc.nextInt();
            char[] list = new char[num];
            String list_str = sc.next();
            for(int i =0;i<num;i++){
                list[i] = list_str.charAt(i);
            }

            for (int i = 0;i< list.length;i++){
                int index = 0;
                switch (list[i]){
                    case 'U': {
                        field[x][y] = '.'; //원래있던 위치 돌려놓기
                        //원하는 위치에 전차 배정
                        //원하는 위치가 평지라면
                        //배열이 끝이 아니라면
                        if((x-1)>=0 && field[x-1][y] == '.'){
                            field[x-1][y] = '^';
                            if(x>0){
                                x--;
                            }
                        }
                        else{field[x][y] = '^';} //평지가 아니라면 원래있던곳에서 방향만 바꾸기
                        break;
                    }
                    case 'D': {
                        field[x][y] = '.';
                        if((x+1)< r && field[x+1][y] == '.'){
                            field[x+1][y] = 'v';
                            if((x)<r-1){
                                x++;
                            }
                        }
                        else{field[x][y] = 'v';}
                        break;
                    }
                    case 'L': {
                        field[x][y] = '.';
                        if((y-1)>=0 && field[x][y-1] == '.'){
                            field[x][y-1] = '<';
                            if(y>0){
                                y--;
                            }
                        }
                        else{field[x][y] = '<';}
                        break;
                    }
                    case 'R': {
                        field[x][y] = '.';
                        if((y+1)< c && field[x][y+1] == '.'){
                            field[x][y+1] = '>';
                            if(y<c-1){
                                y++;
                            }
                        }
                        else{field[x][y] = '>';}
                        break;
                    }
                    case 'S': {
                        switch (field[x][y]){
                            case '^':{
                                index = x;
                                while(true){
                                    if((index-1)<0 ||field[index-1][y] == '#'){break;}
                                    if(field[index-1][y] == '*'){
                                        field[index-1][y] = '.';
                                        break;
                                    }
                                    index--;
                                }
                                break;
                            }
                            case 'v':{
                                index = x;
                                while(true){
                                    if((index+1)>=r ||field[index+1][y] == '#'){break;}
                                    if(field[index+1][y] == '*'){
                                        field[index+1][y] = '.';
                                        break;
                                    }
                                    index++;
                                }
                                break;
                            }
                            case '<':{
                                index = y;
                                while(true){
                                    if((index-1)<0 ||field[x][index-1] == '#'){break;}
                                    if(field[x][index-1] == '*'){
                                        field[x][index-1] = '.';
                                        break;
                                    }
                                    index--;
                                }
                                break;
                            }
                            case '>':{
                                index = y;
                                while(true) {
                                    if((index+1)>=c ||field[x][index+1] == '#'){break;}
                                    if (field[x][index + 1] == '*') {
                                        field[x][index + 1] = '.';
                                        break;
                                    }
                                    index++;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            System.out.print("#"+tc+" ");
            for(int i = 0;i<r;i++){
                for(int j = 0 ; j<c;j++){
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }
}
