// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1. 

// Examples:

// Input: s = "aabacbebebe", k = 3
// Output: 7
// Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
// Input: s = "aaaa", k = 2
// Output: -1
// Explanation: There's no substring with 2 distinct characters.
// Input: s = "aabaaab", k = 2
// Output: 7
// Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.


class Solution {
    public int longestKSubstr(String s, int k) {
      HashMap<Character,Integer> hm=new HashMap<>();
       int l=0;
       int ans=-1;
       for(int r=0;r<s.length();r++){
           char ch=s.charAt(r);
           hm.put(ch,hm.getOrDefault(ch,0)+1);
       while(hm.size()>k){
           char ch1=s.charAt(l);
           hm.put(ch1,hm.get(ch1)-1);
           if(hm.get(ch1)==0){
               hm.remove(ch1);
           }
           l++;
       }
       if(hm.size()==k){
           ans=Math.max(ans,r-l+1);
       }
      }
       return ans;
    }
}
