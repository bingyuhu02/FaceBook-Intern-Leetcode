//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=210159&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3048%5D%5Bvalue%5D%3D2%26searchoption%5B3048%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public static int amazingNumber(int[] nums) {
        int n = nums.length;

        // Keeps track of all the intervals that after right-shifting index, some numbers become amazing number.. 
        for(int i=0; i < n; i++) {
            // If the current number is negative or larger than the biggest index, it won't affect the final result.-google 1point3acres
            if(nums[i] >= n || nums[i] <= 0) continue;

            if(nums[i] > i) {
                // Right shift index i + 1 --> the current index would be n-1 after shifting
                shifts[i + 1] += 1;
                if(nums[i] > i + 1) shifts[i + 1 + n - nums[i]] -= 1;
            } else {
                // There would be two intervals for each nums[i] <= i
                shifts[0] += 1;
                shifts[i - nums[i] + 1] -= 1;

                if(i != n - 1) shifts[i + 1] += 1;
            }
        }

        int sum = 0, max = 0, index = 0;
        for(int i=0; i < shifts.length; i++) {
            sum += shifts[i];
            if(sum > max) {
                max = sum;
                index = i;
            }
        }

        return index;
    }