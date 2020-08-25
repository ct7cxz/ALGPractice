package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxStrLength {

    public static int lengthOfLongestSubstring(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            StringBuilder currentStr = new StringBuilder();
            Set set = new HashSet();
            set.add(s.charAt(i));
            currentStr.append(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }else {
                    currentStr.append(s.charAt(j));
                    set.add(s.charAt(j));
                }
            }
            if(currentStr.length() >= str.length()) {
                str = currentStr;
            }
        }
        System.out.println(str);
        return str.length();
    }

    //下标法
    public static int lengthOfLongestSubstringOther(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringWindows(String s) {
        int[] m = new int[128];
        int len = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            i = Math.max(m[s.charAt(j)], i);
            len = Math.max(len, j - i + 1);
            m[s.charAt(j)] = j + 1;
        }
        return len;
    }

    public static void main(String[] args) {
//        int i = lengthOfLongestSubstringWindows("abcabcbb");
        int[] allNum = new int[10];
        int index = (int) Math.floor(allNum.length / 2);
//        System.out.println(i);
    }
    /**
     * java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
     *   at line 11, Solution.findMedianSortedArrays
     *   at line 54, __DriverSolution__.__helper__
     *   at line 87, __Driver__.main
     */
}
