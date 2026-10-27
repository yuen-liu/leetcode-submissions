class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // make a hashmap where key = unique num, val = count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // make a minheap and pop whenever size reaches k
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        // commands: peek, poll, add
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            min.add(num.getKey());

            if (min.size() > k) {
                min.poll();
            }
        }

        int[] res = new int[k];
        
        for (int i = 0; i < k; i++) {
            res[i] = min.poll();
        }

        return res;

    }
}
