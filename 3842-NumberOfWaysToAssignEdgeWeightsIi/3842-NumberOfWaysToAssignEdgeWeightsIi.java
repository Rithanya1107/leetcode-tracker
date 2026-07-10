// Last updated: 7/10/2026, 8:46:44 AM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    List<Integer>[] graph;
    int[][] up;
    int[] depth;
    int LOG;
    long[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        dfs(1, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int pathEdges =
                    depth[u] + depth[v] - 2 * depth[lca];

            if (pathEdges == 0) {
                ans[i] = 0;
            } else {
                ans[i] = (int) pow2[pathEdges - 1];
            }
        }

        return ans;
    }

    private void dfs(int node, int parent) {
        up[node][0] = parent;

        for (int next : graph[node]) {
            if (next == parent) continue;

            depth[next] = depth[node] + 1;
            dfs(next, node);
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}