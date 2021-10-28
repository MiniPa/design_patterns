package algorithm.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LongParenthesis: 求最长括号合法字符串
 *
 * @version 0.0.1  @date: 2021-10-26
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class LongParenthesis {

    public static void main(String[] args) {
        String s = ")())((())";
        int maxans = 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }

        System.out.println(maxans);
    }


}
