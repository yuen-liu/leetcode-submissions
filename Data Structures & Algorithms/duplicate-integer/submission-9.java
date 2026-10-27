class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> counts = new ArrayList<Integer>();

        for (int num : nums) {
            if (counts.contains(num)) {
                return true;
            }
            counts.add(num);
        }

        return false;

    }
}