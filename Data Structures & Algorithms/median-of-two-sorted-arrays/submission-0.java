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

        // Find median
        if (k % 2 == 1) {
            return arr[k / 2]; // if odd, return the middle element
        } else {
            return (arr[k / 2] + arr[(k / 2) - 1]) / 2.0; // if even, average the two middle elements
        }
    }
}
