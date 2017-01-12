/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

//--------------------------
//bfs
// time complexity 
// time O(n!)
// space O(n!)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i< nums.length;i++){
            //next level
            List<List<Integer>> nextRes = new ArrayList<List<Integer>>();
            // for each list in line
            for(List<Integer> list: res){
                for(int j=0 ; j<list.size()+1 ; j++){
                    //copy a list to nextList
                    List<Integer> nextList = new ArrayList<Integer>(list);
                    //for each postion in list
                    //left - mid - right
                    nextList.add(j,nums[i]);
                    nextRes.add(nextList);
                }
            }
            // move to next level
            res = nextRes;
        }
        return res;
    }
}
// time complexity 
// time O(n! * n )
// space O(n)
// no recursion stack 
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // corner case checked 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list  = new ArrayList<Integer>();
        helper(nums,list,res);
        return res;
    }
    public void helper(int nums[], List<Integer> list, List<List<Integer>> result){
        // base case : fiiled in all position
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        //for each element
        for(int i = 0; i< nums.length;i++){
            // position left = nums left (No duplicate)
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                // next position
                helper(nums,list,result);
                //Empty last position for next iteration
                list.remove(list.size()-1);
            }
        }
    }
}

//--------------------------
//dfs
// time O(n! )
// space O(n)
// swap 
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        // dfs
        // use a HashSet in each postion to remove deplicates
        helper(res,nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int pos){
        if(pos == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int num:nums){
                list.add(num);
            }
            res.add(list);
            return;
        }
        for(int i = pos; i < nums.length; i++ ){
            swap(nums,i,pos);
            helper(res,nums,pos+1);
            swap(nums,i,pos);
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

