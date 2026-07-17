// You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

// Examples :

// Input: s = "abc", k = 2
// Output: 2
// Explanation: Possible substrings are ["ab", "bc"]
// Input: s = "aba", k = 2
// Output: 3
// Explanation: Possible substrings are ["ab", "ba", "aba"]
// Input: s = "aa", k = 1
// Output: 3
// Explanation: Possible substrings are ["a", "a", "aa"]

class Solution {
    public static int countSubstr(String s, int k) {
        return atmost(s,k)-atmost(s,k-1);
    }
    public static int atmost(String s,int k){
        HashMap<Character,Integer> hm=new HashMap<>();
        int ans=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()>k){
                char c=s.charAt(l);
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0){
                    hm.remove(c);
                }
            l++;
            }
            ans+=(r-l+1);
            }
            return ans;
    }
    public static void main(String args[]){
        Scanner v=new Scanner(System.in);
        String s=v.next();
        int k=v.nextInt();
        System.out.println(countSubstr(s,k));
    }
}
