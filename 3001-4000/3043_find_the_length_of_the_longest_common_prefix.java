import java.util.HashSet;

class Solution {
    HashSet<String> hset;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        hset = new HashSet<>();

        for (int a : arr1) {
            addPrefix(a);
        }

        int max = 0;

        for (int a : arr2) {
            int len = getMaxPrefix(a);
            max = Math.max(max, len);
        }

        return max;
    }

    void addPrefix(int num) {
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            hset.add(s.substring(0, i + 1));
        }
    }

    int getMaxPrefix(int num) {
        String s = Integer.toString(num);
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hset.contains(s.substring(0, i + 1))) {
                len = Math.max(len, i + 1);
            } else {
                break;
            }
        }

        return len;
    }
}