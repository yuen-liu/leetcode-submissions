/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // bc graphs may have cycles we can't just do normal recurison
        // need a way to store the prev clones -> hash map!
        HashMap<Node, Node> mem = new HashMap<>();
        return dfs(node, mem);
    }

    private Node dfs(Node node, HashMap<Node, Node> mem) {
        if (node == null) return null; // base case 1: empty

        if (mem.containsKey(node)) return mem.get(node);

        Node copy = new Node(node.val);
        mem.put(node, copy);

        // add neighbors now
        for (Node n : node.neighbors) {
            copy.neighbors.add(dfs(n, mem));
        }

        return copy;
    }
}