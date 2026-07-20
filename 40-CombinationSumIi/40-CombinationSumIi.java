// Last updated: 7/20/2026, 10:22:56 AM
import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;

            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}