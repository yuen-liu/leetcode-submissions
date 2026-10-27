class Solution {
    public int[] countBits(int n) {
        // basically convert n to bitwise representation
        // and then shift until we reach n

        // operation n & (n - 1) removes lowest set bit from n
        // counting the num of operations tells us how many 1s are present
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                res[i]++;
                num &= (num - 1);
            }
        }
        return res;
    }
}
