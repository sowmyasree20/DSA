// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a ≤ b whose sum is closest to target.

// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

// Examples:

// Input: arr[] = [10, 30, 20, 5], target = 25
// Output: [5, 20]
// Explanation: As 5 + 20 = 25 is closest to 25.
// Input: arr[] = [5, 2, 7, 1, 4], target = 10
// Output: [2, 7]
// Explanation: As (4, 5), (2, 7) and (4, 7) both are closest to 10, but absolute difference of (4, 5) is 1, (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
// Input: arr[] = [10], target = 10
// Output: []
// Explanation: As the input array has only 1 element, return an empty array.


class Solution {
    public static ArrayList<Integer> sumClosest(int[] arr, int t) {
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(arr);
        if(arr.length<2){
            return ans;
        }
        int l=0;
        int r=arr.length-1;
        int d=Integer.MAX_VALUE;
        int g=-1;
        while(l<r){
            int sum=arr[l]+arr[r];
            int d1=Math.abs(t-sum);
            int g1=Math.abs(arr[l]-arr[r]);
            if(d1<d || g1>g && d1==d){
                d=d1;
                g=g1;
                ans.clear();
                ans.add(arr[l]);
                ans.add(arr[r]);
            }
            if(sum<t){
                l++; 
            }else if(sum>t){
                r--;
            }else{
                l++;
                r--;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        str=str.substring(1,str.length()-1);
        int t=s.nextInt();
        String v[]=str.split(",");
        int n=v.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(v[i]);
        }
      System.out.println(sumClosest(arr,t)) ; 
    }
}
