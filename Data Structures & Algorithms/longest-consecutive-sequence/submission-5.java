class Solution {
    public int longestConsecutive(int[] nums) {
        // longest consecutive sequence of elements that can be formed

        // brute force soln:
        // iterate through each int in nums
        // and loop through rest of array to check for consecutive sequences

        // smarter soln: use a hash map
        // keep track of possible starts (no other int in the array that is consecutive)
        // from there only loop through those starts to get longest length

        int length = 0;
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        for (int num : nums) {
            if (!seen.contains(num - 1)) {
                int start = num;
                int templength = 1;

                while (seen.contains(start + 1)) {
                    templength++;
                    start++;
                }

                if (templength > length) {
                    length = templength;
                } 
            }
        }

        return length;

    }
}
