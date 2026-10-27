class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for (int num : nums) {
            if (!counts.contains(num)) {
                counts.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}