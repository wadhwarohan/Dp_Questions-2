class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         // base case 
        int dp[][] = new int[n + 1][W + 1];
         for (int i = 0; i <= n; i++) {
           for (int j = 0; j <= W; j++) {
              dp[i][j] = -1;
           }
    }
    return knapSackRecursive(W, wt, val, n, dp);
         
        
    } 
    static int knapSackRecursive(int W, int wt[], int val[], int n, int dp[][]){
    
    
        if(W==0 || n==0){
             return 0;
         }
         if(dp[n][W]!=-1){
             return dp[n][W];
         }
         else{
         if(wt[n-1]<=W){
            dp[n][W]=Math.max(val[n-1]+knapSackRecursive(W-wt[n-1],wt,val,n-1,dp),knapSackRecursive(W,wt,val,n-1,dp));
         }
         else if(wt[n-1]>W){
            dp[n][W]=knapSackRecursive(W,wt,val,n-1,dp);
         }
        
         }
          return dp[n][W];
    }
}