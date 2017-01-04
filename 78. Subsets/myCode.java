import java.util.*;
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] tes = {1,2,3};
        myCode sol = new myCode();
        List<List<Integer>> result = new ArrayList<>(sol.subsets(tes));
        for( List<Integer> list : result){
            for( int i = 0 ; i < list.size(); i++){
                System.out.print(list.get(i) + ",");
            }
            System.out.println();
        }
        System.out.println("Using next()");
        List<Integer> test1 = sol.next(result);
        for(int num : test1 ){
            System.out.print(num);
        }
        List<Integer> test2 = sol.next(result);
        for(int num : test2 ){
            System.out.print(num);
        }
        List<Integer> test3 = sol.next(result);
        for(int num : test3 ){
            System.out.print(num);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add( new ArrayList<>());
        for( int i : nums ){
            int size = res.size();
            for( int j = 0 ; j < size ; j++){
                List<Integer> newList = new ArrayList<>(res.get(j));
                newList.add(i);
                res.add(newList);
            }
        }
        return res;
    }
    public List<Integer> next(List<List<Integer>> subset){
        List<Integer> res = subset.get(0);
        subset.remove(res);
        return res;
    }
}
