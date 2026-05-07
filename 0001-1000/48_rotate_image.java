class Solution {
    private void swap(int[][] nums, int r1, int c1 , int r2 , int c2) {
        int temp = nums[r1][c1];
        nums[r1][c1] = nums[r2][c2];
        nums[r2][c2] = temp;
    }

    private void reverse(int [][]nums){
        for(int i = 0 ; i < nums.length ; i++){
            int start = 0;
            int end = nums.length - 1;

            while(start < end){
                swap(nums , i , start , i , end);
                start++;
                end--;
            }
        }
    }

    private void transpose(int nums[][]){
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                swap(nums , i , j , j , i);
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}
