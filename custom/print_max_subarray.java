class Solution {

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for(int i = 0; i < nums.length; i++) {

            if(sum == 0) {
                start = i;
            }

            sum += nums[i];

            if(sum > max) {
                max = sum;

                ansStart = start;
                ansEnd = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        System.out.print("Subarray: ");

        for(int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        return max;
    }
}
