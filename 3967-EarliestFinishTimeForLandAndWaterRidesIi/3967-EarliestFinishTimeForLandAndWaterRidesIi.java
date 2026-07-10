// Last updated: 7/10/2026, 8:46:36 AM
import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] startA, int[] durA,
                       int[] startB, int[] durB) {

        int m = startB.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = startB[i];
            rides[i][1] = durB[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        long[] prefixMinDur = new long[m];
        prefixMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            prefixMinDur[i] =
                    Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        long[] suffixMinFinish = new long[m];
        suffixMinFinish[m - 1] =
                (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] =
                    Math.min(suffixMinFinish[i + 1],
                             (long) rides[i][0] + rides[i][1]);
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < startA.length; i++) {

            long finishA = (long) startA[i] + durA[i];

            int pos = upperBound(rides, finishA);

            if (pos >= 0) {
                ans = Math.min(ans,
                               finishA + prefixMinDur[pos]);
            }

            if (pos + 1 < m) {
                ans = Math.min(ans,
                               suffixMinFinish[pos + 1]);
            }
        }

        return ans;
    }

    private int upperBound(int[][] rides, long target) {

        int left = 0;
        int right = rides.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (rides[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}