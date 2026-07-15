// Given an array arr[] of strings, group together all strings that are anagrams of each other.

// Two strings are anagrams if they contain the same characters with the same frequencies, possibly in a different order.

// The strings within each group must appear in the same order as they occur in the input array.

// Return a 2D array where each inner array represents a group of anagrams.

// Examples:

// Input: arr[] = ["act", "god", "cat", "dog", "tac"]
// Output: [["act", "cat", "tac"], ["god", "dog"]]
// Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
// Input: arr[] = ["no", "on", "is"]
// Output: [["is"], ["no", "on"]]
// Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.
import java.util.*;
class Solution {
    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
      HashMap<String,ArrayList<String>> hm=new HashMap<>();
      for(String str:arr){
          char[] ch=str.toCharArray();
          Arrays.sort(ch);
          String key=new String(ch);
          if(!hm.containsKey(key)){
              hm.put(key,new ArrayList<>());
          }
          hm.get(key).add(str);
      }
      return new ArrayList<>(hm.values());  
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        str=str.substring(1,str.length()-1);
        str=str.replace("\"","");
        String arr[]=str.split(",\\s*");
        System.out.println(anagrams(arr));
    }
}
