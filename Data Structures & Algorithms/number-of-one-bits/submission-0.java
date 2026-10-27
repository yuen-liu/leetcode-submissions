class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            int remainder = n % 2;
            if (remainder == 1) res++;
            n >>= 1;
        }
        return res;
    }
}