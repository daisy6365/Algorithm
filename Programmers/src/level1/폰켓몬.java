package level1;

import java.util.HashSet;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums1 = {3,1,2,3}; // 2
        int[] nums2 = {3,3,3,2,2,4}; // 3
        int[] nums3 = {3,3,3,2,2,2}; // 2

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }
    public static int solution(int[] nums) {
        int answer = nums.length / 2;

        // 중복 허용 X, 순서 X -> HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        answer = Math.min(answer, hashSet.size());

        return answer;
    }
}
