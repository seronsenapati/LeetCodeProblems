class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = 0;
        int freq[] = new int[n];

        for(int num : nums){
            max = Math.max(max , num);
            if(num < n){
                freq[num]++;
            }
        }

        if(n != max + 1){
            return false;
        }

        if(freq[max] != 2){
            return false;
        }

        for(int i = 1 ; i < freq.length ; i++){
            if(freq[i] == 0){
                return false;
            }
        }

        return true;
    }
}
