class Solution {
    public int getSum(int a, int b) {
        // ex. 2 + 5
        // 010
        // 101

        while (b != 0) {
            int carry = (a & b) << 1; // 0
            a ^= b; // 111
            b = carry; // 0
        }

        return a;
    }
}
