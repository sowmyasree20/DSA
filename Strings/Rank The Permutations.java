// Given a string s consisting of distinct lowercase characters, determine its rank among all its permutations when those are arranged in lexicographically sorted order.

// Note: The rank of a string is its position (starting from 1) in the sorted list of all its permutations.

// Examples:

// Input: s = "abc"
// Output: 1
// Explanation: All permutations of "abc" arranged in lexicographical order are: [abc, acb, bac, bca, cab, cba]. Since "abc" appears first in this list, its rank is 1.
// Input: s = "cba"
// Output: 6
// Explanation: All permutations of "cba" arranged in lexicographical order are: [abc, acb, bac, bca, cab, cba]. Since "cba" appears at the 6th position in this list, its rank is 6.
// Input: s = "string"
// Output: 598
// Explanation: If all permutations of "string" are arranged in lexicographical order, then "string" appears at the 598th position in the list. Therefore, its rank is 598.



import java.util.*;
class Solution {
    public static long findRank(String s) {
        int n=s.length();
        long r=1;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)<s.charAt(i)){
                    c++;
                }
            }
            r+=c*fact(n-i-1);
        }
    return r;   
    }
    public static long fact(int n){
        long f=1;
        for(int i=2;i<=n;i++){
           f*=i;
        }
        return f;
    }
    public static void main(String args[]){
        Scanner k=new Scanner(System.in);
        String s=k.nextLine();
        System.out.println(findRank(s));
    }
}
