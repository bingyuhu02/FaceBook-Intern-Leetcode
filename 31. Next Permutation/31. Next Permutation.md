# 31. Next Permutation

## Idea
* Find two closed elemennt from the end
* If we find the previous is smaller than the second
* Then, we start from the end again, find the first number that is bigger than pevious, and swap the number and previous
* and sort every number after "second", second is included 

```
6, 3 , 4, 9 , 8 , 7 , 1 

previous = 4 , second = 9 
then we found 7 and swap
6 3 7 9 8 4 1
sort 9  8 4 1 , the order is descending for sure
So the result is
6 3 7 1 4 8 9 

```

## Time & Space 
* O(n) & O(1)

## Code

```
public class Solution{
	public void nextPermutation(int[] nums){
		// corner case
		if(nums.length<=1) return;
		int i = nums.length - 1;
		for( ; i>=1 ;i--){
			if(nums[i] > nums[i-1]) break;
		}
		if(i!=0) swap(nums,i-1);
		reverse(nums,i);
	}
    private void swap(int[] a,int i){
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                break;
            }
        }
    }
    //reverse the number after the number we have found
    //the orignal order is descending for sure
    private void reverse(int[] a,int i){
        int first = i;
        int last = a.length-1;
        while(first<last){
            int temp = a[first];
            a[first] = a[last];
            a[last] = temp;
            first ++;
            last --;
        }
    }
}

```

## Followop (Previous Permutaion)

## Idea 
* Change  < to > 
* Change > to < 

## Code

```
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

```