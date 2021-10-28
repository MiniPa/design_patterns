package algorithm.hot100;

/**
 * Regex: 模拟正则表达式匹配
 *
 * @version 0.0.1  @date: 2021-10-25
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class Regex {

    /**
     * @param s 被匹配字符串
     * @param p 正则表达式 "-*"
     * @return
     */
    public boolean isMatch(String s, String p) {
        int slength = s.length();
        int plength = p.length();

        boolean[][] f = new boolean[slength + 1][plength + 1];
        f[0][0] = true;
        for (int si = 0; si < slength; si++) {
            for (int pi = 0; pi < plength; pi++) {
                if (p.charAt(pi - 1) == '*') {
                    f[si][pi] = f[si][pi - 2];
                    if (matches(s, p, si, pi - 1)) {
                        f[si][pi] = f[si][pi] || f[si - 1][pi];
                    }
                } else {
                    if (matches(s, p, si, pi)) {
                        f[si][pi] = f[si - 1][pi - 1];
                    }
                }
            }
        }
        return f[slength][plength];
    }

    /**
     * 字符串 s, 正则表达式 p, 在 si, pi位置是否匹配
     *
     * s 为空，不匹配
     * pi - 1 位置处为 '.' 匹配任意字符串
     * s 在 si - 1 处字符串 和 p 在 pi -1 处字符串相等，匹配
     *
     * p 为 * 在上层处理
     *
     * @return
     */
    private boolean matches(String s, String p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        if (p.charAt(pi - 1) == '.') {
            return true;
        }
        return s.charAt(si - 1) == p.charAt(pi - 1);
    }


}
