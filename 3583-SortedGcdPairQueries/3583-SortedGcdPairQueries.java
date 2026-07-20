// Last updated: 7/20/2026, 10:17:00 AM
import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // Count numbers divisible by i
        int[] count = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                count[i] += freq[j];
            }
        }

        // exactPairs[i] = number of pairs with gcd exactly i
        long[] exactPairs = new long[max + 1];

        for (int i = max; i >= 1; i--) {
            long totalPairs = (long) count[i] * (count[i] - 1) / 2;

            for (int j = i * 2; j <= max; j += i) {
                totalPairs -= exactPairs[j];
            }

            exactPairs[i] = totalPairs;
        }

        // Prefix sum
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exactPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            long target = queries[k] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[k] = left;
        }

        return ans;
    }
}