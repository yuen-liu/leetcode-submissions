class Solution {
    public int reverseBits(int n) {
        int res = 0;
        // key here: all integers are 32 bits
        // look at individual digits right to left
        // do this by right shifting by index i
        // then & with 1 so only the index digit remains
        // then append to res with or and shift left
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res |= (bit << (31 - i));
        }
        return res;
    }
}
