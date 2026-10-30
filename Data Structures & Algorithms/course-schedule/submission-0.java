class Solution {

    private HashMap<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> seen = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we need to check for a cycle for each prereq
        // a) need to store unique/relevant courses
        // b) need to store all paths/cycles for said course
        // use a hashmap and hashset!

        // init our hashmap
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) { // add prereqs to the map!
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false; // cycle detected for any course
        }

        return true;
    }

    private boolean dfs(int course) {
        if (seen.contains(course)) return false; // cycle!

        if (map.get(course).isEmpty()) return true; // no prereqs!

        // add our course to seen
        seen.add(course);

        for (int pre : map.get(course)) {
            if (!dfs(pre)) return false; // cycle detected in other preq
        }

        // back track: clear the set for all others
        seen.remove(course);

        map.put(course, new ArrayList<>()); // back track: path clear!

        return true;

    }
}
