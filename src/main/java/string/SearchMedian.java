package string;

/**
 * 寻找两个正序数组的中位数
 */
public class SearchMedian {

    public static double findMedianSortedArraysMe(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] allNum = new int[length1 + length2];
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        while (i < allNum.length) {
            if (length1 > index1 && length2 > index2) {
                if (nums1[index1] <= nums2[index2]) {
                    allNum[i] = nums1[index1];
                    index1++;
                } else {
                    allNum[i] = nums2[index2];
                    index2++;
                }
                i++;
            }
            if (length1 > index1 && length2 <= index2) {
                allNum[i] = nums1[index1];
                index1++;
                i++;
            }
            if (length2 > index2 && length1 <= index1) {
                allNum[i] = nums2[index2];
                index2++;
                i++;
            }
        }
        int index = (int) Math.floor(allNum.length / 2);
        if (allNum.length % 2 == 0) {
            return (float)(allNum[index - 1] + allNum[index]) / 2;
        } else {
            return allNum[index];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double medianSortedArraysMe = findMedianSortedArraysMe(nums1, nums2);
        System.out.println(medianSortedArraysMe);
    }
}
