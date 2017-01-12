public void sortKCategory(int[] nums, int k) {
        //assume getCat returns 1, ...k
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        int min = 1, max = k;
        while (min < max) {
            while (cur <= right) {
                if (getCat(nums[cur]) == min) {
                    swap(nums, left, cur);
                    cur++;
                    left++;
                } else if (getCat(nums[cur]) == max) {
                    swap(nums, right, cur);
                    right--;
                } else {
                    cur++;
                }
            }
            cur = left;
            min++;
            max--;
        }
    }