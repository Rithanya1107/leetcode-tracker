// Last updated: 7/10/2026, 8:46:29 AM
import java.util.*;

class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;

        long[] prefix = new long[n+1];
        for(int i=0;i<n; i++){
            prefix [i + 1] =prefix[i] + nums[i];
        }
        
        int ans = 0;

        for(int l =0; l<n; l++){
            for(int r= l; r<n; r++){
                long sum = prefix[r+1] - prefix[l];
                if(sum % 10 !=x){
                    continue;
                }

                long first =sum;
                while (first >= 10){
                    first/= 10;
                }

                if(first == x){
                    ans++;
                }
            }
        }
        return ans;
    }
}