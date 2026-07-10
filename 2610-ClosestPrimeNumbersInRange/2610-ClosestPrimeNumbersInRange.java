// Last updated: 7/10/2026, 8:46:46 AM
class Solution {

    public int[] closestPrimes(int left, int right) {

        boolean[] prime = new boolean[right + 1];

        for (int i = 2; i <= right; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= right; i++) {

            if (prime[i]) {

                for (int j = i * i; j <= right; j += i) {
                    prime[j] = false;
                }
            }
        }

        int prev = -1;
        int num1 = -1;
        int num2 = -1;
        int minGap = Integer.MAX_VALUE;

        for (int i = Math.max(2, left); i <= right; i++) {

            if (prime[i]) {

                if (prev != -1) {

                    int gap = i - prev;

                    if (gap < minGap) {
                        minGap = gap;
                        num1 = prev;
                        num2 = i;
                    }
                }

                prev = i;
            }
        }

        return new int[]{num1, num2};
    }
}