// Last updated: 7/10/2026, 8:48:08 AM
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums ){
            result ^= num;
        }
        return result;
    }
}