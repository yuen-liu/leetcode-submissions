class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> count = new ArrayList<Integer>();

        for (int num : nums) {
            if (count.contains(num)) {
                return true;
            }
            count.add(num);
        }

        return false;
    }
}