package level2;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args){
        System.out.println(solution("FRANCE", "french")); // 16384
        System.out.println(solution("handshake", "shake hands")); // 65536
        System.out.println(solution("aa1+aa2", "AAAA12")); // 43690
        System.out.println(solution("E=M*C^2", "e=m*c^2")); // 65536
    }

    public static int solution(String str1, String str2) {
        Map<String, Integer> strMap1 = new HashMap<>();
        Map<String, Integer> strMap2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 원소 쪼개기
        for (int i = 0; i < str1.length()-1; i++) {
            char temp_c1 = str1.charAt(i);
            char temp_c2 = str1.charAt(i+1);
            if((temp_c1 < 'a' || temp_c1 > 'z') || (temp_c2 < 'a' || temp_c2 > 'z')) continue;
            String temp = str1.charAt(i)+""+ str1.charAt(i+1);
            if(strMap1.containsKey(temp)){
                strMap1.replace(temp, strMap1.get(temp)+1);
            }
            else{
                strMap1.put(temp, 1);
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            char temp_c1 = str2.charAt(i);
            char temp_c2 = str2.charAt(i+1);
            if((temp_c1 < 'a' || temp_c1 > 'z') || (temp_c2 < 'a' || temp_c2 > 'z')) continue;
            String temp = str2.charAt(i)+""+ str2.charAt(i+1);
            if(strMap2.containsKey(temp)){
                strMap2.replace(temp, strMap2.get(temp)+1);
            }
            else{
                strMap2.put(temp, 1);
            }
        }

        if(strMap1.size() == 0 && strMap2.size() == 0) return 65536;

        double intersection = 0;
        double union = 0;

        // 교집합 -> map.value가 2 이상(중복일 땐) 최솟값 map.value 찾기
        for(String s : strMap1.keySet()){
            if(strMap2.containsKey(s)){
                // 교집합 일때 -> 해당 키값의 최솟값
                int temp = Math.min(strMap1.get(s), strMap2.get(s));
                intersection += temp;
            }
        }

        // 합집합 - > map.value가 2 이상(중복일 땐) 최댓값 map.value 찾기
        for(String s : strMap1.keySet()){
            if(strMap2.containsKey(s)){
                // 교집합 일때 -> 해당 키값의 최댓값
                int temp = Math.max(strMap1.get(s), strMap2.get(s));
                union += temp;
            }
            else{
                // 교집합 아니면 일단 strMap1만 넣기
                union += strMap1.get(s);
            }
        }
        // 합집합이니까 strMap2도 넣기
        for(String s : strMap2.keySet()){
            if(strMap1.containsKey(s)) continue;
            union += strMap2.get(s);
        }

        int answer = (int) ((intersection / union) * 65536);

        return answer;
    }
}
