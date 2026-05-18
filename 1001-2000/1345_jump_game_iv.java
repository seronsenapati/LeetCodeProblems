import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int index = queue.poll();

                if (index == n - 1) {
                    return steps;
                }

                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }

                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }

                List<Integer> sameValueIndices = graph.get(arr[index]);
                if (sameValueIndices != null) {
                    for (int nextIndex : sameValueIndices) {
                        if (!visited[nextIndex]) {
                            visited[nextIndex] = true;
                            queue.offer(nextIndex);
                        }
                    }
                    graph.remove(arr[index]);
                }
            }

            steps++;
        }

        return -1;
    }
}