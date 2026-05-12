import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0, count2 = 0;

        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && el2 != nums[i]) {
                count1 = 1;
                el1 = nums[i];
            }

            else if (count2 == 0 && el1 != nums[i]) {
                count2 = 1;
                el2 = nums[i];
            }

            else if (nums[i] == el1) {
                count1++;
            }

            else if (nums[i] == el2) {
                count2++;
            }

            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) {
                count1++;
            }

            if (nums[i] == el2) {
                count2++;
            }
        }

        int min = n / 3 + 1;

        List<Integer> list = new ArrayList<>();

        if (count1 >= min) {
            list.add(el1);
        }

        if (count2 >= min && el2 != el1) {
            list.add(el2);
        }

        return list;
    }
}
