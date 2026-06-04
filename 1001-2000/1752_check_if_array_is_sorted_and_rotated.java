class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0 ; 
        for(int i=0 ; i<n ; i++){
            if(nums[i] > nums[(i+1) % n]){ // allows circular checking 
                count++;

                /*
                if arr = [3,4,5,1,2]
                3 > 4 ? No
                4 > 5 ? No
                5 > 1 ? Yes  count=1
                1 > 2 ? No
                2 > 3 ? No
                */
            }
        }
        return count <= 1;
    }
}
