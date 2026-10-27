class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return top k most frequent elements within the array
        int[] res = new int[k];

        // less optimal way to do this:
        // iterate thru nums, keep a hash map of every unique digit and its counts
        // then return top k largest values -> indices
        // do this by using a minheap of size k

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry.getKey());

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
