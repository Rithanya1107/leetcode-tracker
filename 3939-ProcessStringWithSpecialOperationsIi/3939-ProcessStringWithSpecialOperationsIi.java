// Last updated: 7/10/2026, 8:46:39 AM
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long LIMIT = (long) 1e15 + 5;

        long[] len = new long[n + 1];
        len[0] = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = Math.min(LIMIT, len[i] + 1);
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = Math.min(LIMIT, len[i] * 2);
            } else { // '%'
                len[i + 1] = len[i];
            }
        }

        if (k < 0 || k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = len[i];
            long currLen = len[i + 1];

            if (ch >= 'a' && ch <= 'z') {
                if (k == currLen - 1) {
                    return ch;
                }
            } else if (ch == '*') {
            } else if (ch == '#') {
                if (prevLen > 0) {
                    k %= prevLen;
                }
            } else { // '%'
                if (prevLen > 0) {
                    k = prevLen - 1 - k;
                }
            }
        }

        return '.';
    }
}