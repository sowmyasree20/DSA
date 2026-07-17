// Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

// Examples:

// Input: s = "abcc", k = 2
// Output: 1
// Explaination: Possible substring of length k = 2 are,
// ab : 2 distinct characters
// bc : 2 distinct characters
// cc : 1 distinct characters
// Only one valid substring so, count is equal to 1.
// Input: "aabab", k = 3
// Output: 3
// Explaination: Possible substring of length k = 3 are, 
// aab : 2 distinct charcters
// aba : 2 distinct characters
// bab : 2 distinct characters
// All these substring are valid so, the total count is equal to 3.


class Solution {
    public int substrCount(String s, int k) {
      HashMap<Character,Integer> hm=new HashMap<>();
      int l=0;
      int ans=0;
      for(int r=0;r<s.length();r++){
          char ch=s.charAt(r);
          hm.put(ch,hm.getOrDefault(ch,0)+1);
          if(r-l+1>k){
             char c=s.charAt(l);
             hm.put(c,hm.get(c)-1);
             if(hm.get(c)==0){
                 hm.remove(c);
             }
             l++;
          }
          if(r-l+1==k && hm.size()==k-1){
              ans++;
          }
      }
     return ans;   
    }
}
