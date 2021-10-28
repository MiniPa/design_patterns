package algorithm.hot100;

/**
 * JumpNum:
 *
 * @version 0.0.1  @date: 2021-10-26
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class JumpNum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int n = nums.length;

        int rightMost = 0;

        boolean isOk = false;

        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n-1) {
                    isOk = true;
                    break;
                }
            }
        }

        System.out.println("isOk = " + isOk);
    }

}
