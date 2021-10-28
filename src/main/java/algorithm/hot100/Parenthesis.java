package algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Brakets: 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 *
 * @version 0.0.1  @date: 2021-10-26
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class Parenthesis {

    List[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                System.out.println("c ==> " + c);
                System.out.println("generateLeft n ==================> " + c);

                List<String> generateLeft = generate(c);

                System.out.println("generateLeft：" + generateLeft);

                for (String left : generateLeft) {


                    int rightn = n - 1 - c;

                    System.out.println("generateRight n ==================> " + rightn);

                    List<String> generateRight = generate(rightn);

                    System.out.println("generateRight：" + generateRight);

                    for (String right : generateRight) {
                        String kh = "(" + left + ")" + right;
                        ans.add(kh);
                        System.out.println("c == " + c + ": " + kh);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.generate(3));
    }

}
