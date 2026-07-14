Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
// Explanation: This array can never be partitioned into two such parts.

  class Solution {
    static boolean equalPartition(int arr[]) {
        int sum=0;
       for(int num:arr){
         sum+=num;
       }
       if(sum%2!=0){
           return false;
       }
       int t=sum/2;
       boolean dp[]=new boolean[t+1];
       dp[0]=true;
       for(int num:arr){
           for(int i=t;i>=num;i--){
               dp[i]=dp[i] || dp[i-num];
           }
       }
      return dp[t] ;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        str=str.substring(1,str.length()-1);
        String v[]=str.split(",");
        int n=v.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(v[i]);
        }
        System.out.println(equalPartition(arr));
    }
}
