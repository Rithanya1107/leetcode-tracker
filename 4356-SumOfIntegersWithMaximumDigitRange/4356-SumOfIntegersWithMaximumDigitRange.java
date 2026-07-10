// Last updated: 7/10/2026, 8:46:25 AM
class Solution {
    public int maxDigitRange(int[] nums){
        int maxRange = -1;
        int sum = 0;

        for(int num : nums){
            int range = getDigitRange(num);
            if(range > maxRange){
                maxRange = range;
            }
        }

        for(int num : nums){
            if(getDigitRange(num) == maxRange){
                sum += num;
            }
        }
        return sum;
    }
    private int getDigitRange(int num){
        int maxDigit = 0;
        int minDigit = 9;

        while (num > 0){
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            minDigit = Math.min(minDigit, digit);
            num /= 10;
        }
        return maxDigit - minDigit;
    }
}