class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        
        int[] arr = new int[n + m];

       

        for(int i = 0; i < n; i++){
            arr[i] = nums1[i];
        }
        
        for(int i = 0; i < m; i++){
            arr[i + n] = nums2[i];

        }
        Arrays.sort(arr);

        int totallength = n + m;

        if(totallength % 2 == 1){
            return arr[totallength / 2];
        }else{
            int mid1 = totallength / 2;
            int mid2 = mid1 - 1;
            return (arr[mid1] + arr[mid2]) / 2.0;
        }
    }
}
