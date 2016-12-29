public class Solution {
    public List<List<Integer>> combinationSum(int[] n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
        helper(res,new ArrayList<Integer>(),n,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int pos){
        if( remain < 0 ) return;
        if( remain == 0 ) res.add(new ArrayList<>(temp));
        else{
            for(int i = pos; i < nums.length; i++ ){
                temp.add(nums[i]);
                helper(res,temp,nums,remain-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}