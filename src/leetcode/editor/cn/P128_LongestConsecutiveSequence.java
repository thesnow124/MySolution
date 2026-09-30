//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2987 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 最长连续序列
 *
 * @author DY
 * @date 2026-09-28 18:38:18
 */
public class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        //noinspection InstantiationOfUtilityClass
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int max = 0;
            int count = 0;
            for (int i : nums) {
                if (!set.contains(i - 1)) {
                    int j = i;
                    while (set.contains(j)) {
                        count++;
                        set.remove(j);
                        j++;
                    }
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
