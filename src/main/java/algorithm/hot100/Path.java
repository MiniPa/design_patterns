package algorithm.hot100;

/**
 * Path:
 *
 * @version 0.0.1  @date: 2021-10-26
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class Path {

    public static void main(String[] args) {
        int m = 3, n = 7;

        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        System.out.println(f[m - 1][n - 1]);
    }


}
