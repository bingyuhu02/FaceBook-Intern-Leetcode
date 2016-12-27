import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] test = {-1,0,1,2,-1,-4};
        myCode sol = new myCode();
        List<List<Integer>> res = sol.threeSum(test);
        for(List<Integer> list : res){
            for( Integer i : list ){
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> threeSum(int[] n){
        Arrays.sort(n);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n.length; i++){
            if( !map.containsKey(n[i])){
                map.put(n[i],1);
            } else {
                map.put(n[i], map.get(n[i]) + 1 );
            }
        }
        for( int i = 0 ; i < n.length ; i ++){
            for( int j = i + 1 ; j < n.length ; j++){
                int rest = 0 - n[i] - n[j];
                int count = 0;
                if(n[i] == rest) count++;
                if(n[j] == rest) count++;
                if(map.containsKey(rest) && map.get(rest) > count && rest >= n[j]){
                    res.add(Arrays.asList(n[i],n[j],rest));
                }
                while( j < n.length - 1 && n[j] == n[j+1]) j++;    
            }
            while( i < n.length -1 && n[i] == n[i+1] ) i++;
        }
        return res;
    }
}
