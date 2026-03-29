class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int k = n + m;

        int[] arr = new int[k];

        // Copy nums1 into arr
        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i];
        }

        // Copy nums2 into arr (corrected index)
        for (int i = 0; i < m; i++) {
            arr[n + i] = nums2[i];
        }

        // Sort the merged array
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
