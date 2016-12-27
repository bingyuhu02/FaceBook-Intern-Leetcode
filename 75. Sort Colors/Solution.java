public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 1, 2, 1, 0, 0,1,1,1,1};
        Solution sol = new Solution();
        sol.sortColors(nums);
        for( int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i]);
        }
    }
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int first = map.get(0);
        int second = map.get(1);
        int third = map.get(2);
        for (int i = 0; i < first; i++) nums[i] = 0;
        for (int i = first; i < second + first; i++) nums[i] = 1;
        for (int i = second + first; i < third + second + first; i++) nums[i] = 2;
    }
}
