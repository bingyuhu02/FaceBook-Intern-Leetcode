public class Solution {
    public void sortColors(int[] nums) {
        if( nums == null || nums.length <= 1) return;
        // left : first wall , the end of 0
        // right : second wall , the start of 2 
        // cur : scanner for unprocessed data
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while(cur <= right){
            if(nums[cur] == 0) swap(nums,cur++,left++);
            else if(nums[cur] == 2) swap(nums,cur,right--);
            else cur++;
        }
    }
    private void swap(int[] nums, int a , int b){
        if(nums[a] != nums[b]){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;   
        }
    }
}