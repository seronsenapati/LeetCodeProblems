import java.util.ArrayList;

class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int number : nums) {
            if (number < 10) {
                list.add(number);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();

                while (number > 0) {
                    temp.add(number % 10);
                    number = number / 10;
                }

                for (int i = temp.size() - 1; i >= 0; i--) {
                    list.add(temp.get(i));
                }
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}