class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] a = nums1;
        int[] b = nums2;

        if (m > n) {
            a = nums2;
            b = nums1;
            int temp = m;
            m = n;
            n = temp;
        }

        int imin = 0;
        int imax = m;
        int halfL = (n + m + 1) / 2;
        // if (B[j-1] > A[i]) set imin = i+1
        // if (A[i-1] > B[j]) set imax = i-1
        while(imin <= imax) {
            int i = (imax + imin) / 2;
            int j = hallfL - i;
            if (b[j - 1] > a[i]) {
                imin = i + 1;
            } else if (a[i - 1] > B[j]) {
                imax = i - 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = b[j - 1];
                } else if (j == 0) {
                    leftMax = a[i - 1];
                } else {
                    leftMax = Math.max(b[j - 1], a[i - 1]);
                }
                if ((n + m) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (i == m) {
                    rightMin = b[j];
                } else if (j == n) {
                    rightMin = a[i];
                } else {
                    rightMin = Math.min(b[j], a[i]);
                }

                return (leftMax + rightMin) / 2.0;
            }
        }

        return 0.0;
    }
}
