// Last updated: 7/10/2026, 8:47:56 AM
class Solution {

    public int trailingZeroes(int n) {

        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}