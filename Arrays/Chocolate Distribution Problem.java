// Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets among m students such that -
//       i. Each student gets exactly one packet.
//      ii. The difference between maximum number of chocolates given to a student and minimum number is minimum and return that minimum possible difference.

// Examples:

// Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
// Output: 6
// Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing m packets as [3, 4, 9, 7, 9].
// Input: arr = [7, 3, 2, 4, 9, 12, 56], m = 3
// Output: 2
// Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing m packets as [3, 2, 4].
// Input: arr = [3, 4, 1, 9, 56], m = 5
// Output: 55
// Explanation: With 5 packets for 5 students, each student will receive one packet, so the difference is 56 - 1 = 55.


import java.util.*;
class Solution {
    public static int findMinDiff(int arr[], int m) {
        if(m==0 || arr.length==0){
            return 0;
        }
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-m+1;i++){
            ans=Math.min(ans,arr[i+m-1]-arr[i]);
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        str=str.substring(1,str.length()-1);
        String v[]=str.split(",\\s*");
        int m=s.nextInt();
        int n=v.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(v[i]);
        }
        System.out.println(findMinDiff(arr,m));
    }
}
