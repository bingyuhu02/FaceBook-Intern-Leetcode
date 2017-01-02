public class Solution {
    public int maxXing(int[][] nums) {
        if (nums.length == 0 || nums[0].length == 0)
            return 0;
        int rowHit = 0;
        int[] colHit = new int[nums[0].length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) continue;
                // get rowHit
                if (j == 0 || nums[i][j - 1] == 0) {
                    rowHit = 0;
                    while (j + rowHit < nums[0].length && nums[i][j + rowHit] == 1)
                        rowHit ++;
                }
                // get colHit
                if (i == 0 || nums[i - 1][j] == 0) {
                    colHit[j] = 0;
                    while (i + colHit[j] < nums.length && nums[i + colHit[j]][j] == 1)
                        colHit[j] ++;
                }
                max = Integer.max(max, colHit[j] + rowHit - 1);
            }
        }
        return max;
    }
}