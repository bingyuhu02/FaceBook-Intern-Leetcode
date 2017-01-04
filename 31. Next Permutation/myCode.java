import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(2);
        test.add(3);

        myCode sol = new myCode();
        List<Integer> res = sol.previousPermutation(test);
        for( int i : res){
            System.out.print(i);
        }
    }
    public List<Integer> previousPermutation(List<Integer> n){
        // corner case
        List<Integer> nums = new ArrayList<>(n);
        if(nums.size()<=1) return nums;
        int i = nums.size() - 1;
        for( ; i>=1 ;i--){
            if(nums.get(i) < nums.get(i-1)) break;
        }
        if(i!=0) swap(nums,i-1);
        reverse(nums,i);
        return nums;
    }
    private void swap(List<Integer> a,int i){
        for(int j = a.size()-1;j>i;j--){
            if(a.get(j)<a.get(i)){
                int temp = a.get(j);
                a.set(j,a.get(i));
                a.set(i,temp);

                break;
            }
        }
    }
    //reverse the number after the number we have found
    //the orignal order is descending for sure
    private void reverse(List<Integer> a,int i){
        int first = i;
        int last = a.size()-1;
        while(first<last){
            int temp = a.get(first);
            a.set(first,a.get(last));
            a.set(last,temp);
            first ++;
            last --;
        }
    }
}
