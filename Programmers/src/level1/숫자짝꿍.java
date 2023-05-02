package level1;
import java.util.*;

class 숫자짝꿍 {
    public String solution(String X, String Y) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }

        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }

        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }


        if(list.isEmpty()) return "-1";

        list.sort(Comparator.reverseOrder());
        if(list.get(0).equals("0")) return "0";

        for(String s : list){
            sb.append(s);
        }

        return sb.toString();
    }
}