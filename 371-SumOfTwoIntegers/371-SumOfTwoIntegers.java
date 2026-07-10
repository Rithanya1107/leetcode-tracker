// Last updated: 7/10/2026, 8:47:24 AM
class Solution {
    public int getSum(int a, int b) {
        while (b != 0){
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}