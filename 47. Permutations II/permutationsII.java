/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
//dfs
// Time : o(n!)
// space :o(n^2) 
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(nums == null|| nums.length==0) return res;
        helper(res,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums, int pos){
        if(pos==nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int num :nums){
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> used = new HashSet<Integer>();
        for(int i = pos ; i < nums.length ; i++){
            if(used.add(nums[i])){
                swap(nums,i,pos);
                helper(res,nums,pos+1);
                swap(nums,i,pos);
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}