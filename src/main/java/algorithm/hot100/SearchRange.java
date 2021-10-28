package algorithm.hot100;

/**
 * SearchRange:
 *
 * @version 0.0.1  @date: 2021-10-26
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) -1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid -1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
