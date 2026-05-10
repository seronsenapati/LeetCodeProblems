class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Set<Integer>set = new HashSet<>();

        for(int number : nums){
            set.add(number);
        }

        int longestLength = 1;

        for(int number : set){
            if(!set.contains(number - 1)){
                int curr = number;
                int count = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }

                longestLength = Math.max(longestLength , count);
            }
        }

        return longestLength;
    }
}
