// Last updated: 7/10/2026, 8:46:27 AM
class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;
        while (n > 0){
            int digit = n % 10;
            digitSum += digit;
            squareSum += digit * digit;
            n /= 10;
        }
        if (squareSum - digitSum >= 50){
            return true;
        }
        else {
            return false;
        }
    }
}