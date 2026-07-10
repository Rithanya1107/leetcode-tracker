// Last updated: 7/10/2026, 8:46:43 AM
import java.util.*;

class Solution {

    private static final long MOD = 1_000_000_007L;
    private List<Integer>[] graph;
    private int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0, 0);

        if (maxDepth == 0) {
            return 0;
        }

        return (int) power(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int depth) {

        maxDepth = Math.max(maxDepth, depth);

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1);
            }
        }
    }

    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}