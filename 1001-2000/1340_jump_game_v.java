import java.util.*;

class Solution {
    int jumps[];

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        jumps = new int[n];
        Arrays.fill(jumps, -1);

        for (int i = 0; i < n; i++) {
            jumps[i] = dfs(i, arr, d);
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, jumps[i]);
        }

        return max;
    }

    int dfs(int idx, int[] arr, int d) {
        if (jumps[idx] != -1) {
            return jumps[idx];
        }

        jumps[idx] = 1;

        for (int i = idx - 1; i >= 0 && idx - i <= d; i--) {
            if (arr[i] < arr[idx]) {
                jumps[i] = dfs(i, arr, d);
                jumps[idx] = Math.max(jumps[idx], jumps[i] + 1);
            } else {
                break;
            }
        }

        for (int i = idx + 1; i < arr.length && i - idx <= d; i++) {
            if (arr[i] < arr[idx]) {
                jumps[i] = dfs(i, arr, d);
                jumps[idx] = Math.max(jumps[idx], jumps[i] + 1);
            } else {
                break;
            }
        }

        return jumps[idx];
    }
}
