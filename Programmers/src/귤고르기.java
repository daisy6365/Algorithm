import java.util.*;

public class 귤고르기 {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public static void main(String[] args) {
        //int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        //int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};
        //System.out.println(solution(6, tangerine1));
        System.out.println(solution(4, tangerine2));
        //System.out.println(solution(2, tangerine3));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        for (int i = 0; i < tangerine.length; i++) {
            treeMap.put(tangerine[i], treeMap.getOrDefault(tangerine[i], 0) + 1);
        }

        // 갯수 크기순으로 정렬
        List<Integer> keylist = new ArrayList<>(treeMap.keySet());
        Collections.sort(keylist, new customComparator());

        for (Integer t : keylist) {
            if(k <= 0) break;
            // 종류 카운트
            answer++;
            // 해당 갯수만큼 빼줌
            k -= treeMap.get(t);
        }

        return answer;
    }

    private static class customComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return treeMap.get(o2).compareTo(treeMap.get(o1));
        }
    }
}

