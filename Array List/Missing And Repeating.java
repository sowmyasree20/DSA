// Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.

// Examples:

// Input: arr[] = [2, 2]
// Output: [2, 1]
// Explanation: Repeating number is 2 and the missing number is 1.
// Input: arr[] = [1, 3, 3] 
// Output: [3, 2]
// Explanation: Repeating number is 3 and the missing number is 2.
// Input: arr[] = [4, 3, 6, 2, 1, 1]
// Output: [1, 5]
// Explanation: Repeating number is 1 and the missing number is 5.

class Solution {
    public static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int d=-1;
        int m=-1;
        int freq[]=new int[n+1];
        for(int num:arr){
            freq[num]++;
        }
        for(int i=1;i<=n;i++){
            if(freq[i]==2){
                d=i;
            }else if(freq[i]==0){
                m=i;
            }
        }
       ans.add(d);
       ans.add(m);
       return ans; 
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        str=str.substring(1,str.length()-1);
        String v[]=str.split(",");
        int n=v.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(v[i]);
        }
        System.out.println(findTwoElement(arr));
    }
}
