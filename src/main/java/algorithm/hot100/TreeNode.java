package algorithm.hot100;

/**
 * TreeNode:
 *
 * @version 0.0.1  @date: 2021-10-27
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
