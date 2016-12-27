public class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        if( n == null || n.length == 0) return res;
        Arrays.sort(n);
        for(int i = 0 ; i< n.length - 2 ; i++){
            if ( i -1 >= 0  && n[i] == n[i-1]) continue;
            int left = i + 1, right = n.length - 1;
            while(left < right){
                int sum = n[i] + n[left] + n[right];
                if( sum == 0 ){
                    res.add(Arrays.asList(n[i],n[left],n[right]));
                    left++;
                    right--;
                    while( left < right && n[left] == n[left-1]) {
                        left++;
                    }
                    while( left < right && n[right] == n[right+1]){
                        right--;
                    } 
                }
                else if ( sum < 0) left++;
                else right--;
            }
        }
        return res;
    }
}