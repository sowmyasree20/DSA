// Given two strings s and p, find the smallest substring in s consisting of all the characters (including duplicates) of the string p.

// Return empty string in case no such substring is present. 
// If there are multiple such substring of the same length found, return the one with the least starting index.
// Examples:

// Input: s = "timetopractice", p = "toc"
// Output: "toprac"
// Explanation: "toprac" is the smallest substring in which "toc" can be found.
// Input: s = "zoomlazapzo", p = "oza"
// Output: "apzo"
// Explanation: "apzo" is the smallest substring in which "oza" can be found.
// Input: s = "zoom", p = "zooe"
// Output: ""
// Explanation: No substring is present containing all characters of p.


class Solution {
    public static String minWindow(String s, String p) {
    
    if(p.length()>s.length()){
        return "";
    }
    int freq[]=new int[256];
    for(char ch:p.toCharArray()){
       freq[ch]++; 
    }
    int start=-1;
    int l=0;
    int c=p.length();
    int len=Integer.MAX_VALUE;
    for(int r=0;r<s.length();r++){
        char ch=s.charAt(r);
        if(freq[ch]>0){
            c--;
        }
        freq[ch]--;
        while(c==0){
            if(r-l+1<len){
                len=r-l+1;
                start=l;
            }
            char l1=s.charAt(l);
            freq[l1]++;
            if(freq[l1]>0){
                c++;
            }
            l++;
        }
    }
        if(start==-1){
            return "";
        }
   return s.substring(start,start+len);
}
}
