
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        if( n == null || n.length == 0 ) return res;
        Arrays.sort(n);
        res.add(new ArrayList<>());
        int begin = 0;
        for(int i =0 ; i < n.length ; i++){
            if( i == 0 || n[i] != n[i-1]) begin = 0;
            int size = res.size();
            for( int j = begin ; j < size; j++){
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(n[i]);
                res.add(temp);
            }
            begin = size;
        }
        return res;
    }
}


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    public void dfs(int[] n, int index, List<Integer> list, List<List<Integer>> res){
        res.add(list);
        for( int i = index; i < n.length ; i++){
            if( i > index && n[i] == n[i-1]) continue;
            List<Integer> newList = new ArrayList<>(list);
            newList.add(n[i]);
            dfs(n,i+1,newList,res);
        }
    }
}