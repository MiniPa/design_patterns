package algorithm.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Area:
 *
 * @version 0.0.1  @date: 2021-10-27
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class Area {



    public static void main(String[] args) {
        int[] heights = new int[]{1,3,4,2,6,2,5,5,1};
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> moon_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!moon_stack.isEmpty() && heights[moon_stack.peek()] > heights[i]) {
                moon_stack.pop();
            }
            left[i] = moon_stack.isEmpty() ? -1 : moon_stack.peek();
            moon_stack.push(i);
        }

        moon_stack.clear();
        for (int i = n -1; i >= 0; i--) {
            while (!moon_stack.isEmpty() && heights[moon_stack.peek()] >= heights[i]) {
                moon_stack.pop();
            }
            right[i] = moon_stack.isEmpty() ? n : moon_stack.peek();
            moon_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        System.out.println(ans);
    }


}
