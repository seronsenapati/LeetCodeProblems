class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int min = prices[0];
        int maxProfit = 0;
        
        for(int i = 1 ; i < prices.length ; i++){
            int cost = prices[i] - min;
            maxProfit = Math.max(maxProfit , cost);
            min = Math.min(min , prices[i]);
        }
    
        return maxProfit;
    }
}
