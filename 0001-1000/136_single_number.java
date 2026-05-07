class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int i = 0 ; i < nums.length ; i++){
            xor = xor^nums[i];   // XOR of same number gives zero
        }

        return xor;
    }
}
