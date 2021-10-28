package algorithm.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TwoTree: 二叉树层序遍历
 *
 * @version 0.0.1  @date: 2021-10-27
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class TwoTree {

    public List<List<Integer>> levelOrder(TreeNode2 root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i <= currentLevelSize; i++) {
                TreeNode2 node = queue.poll();
                level.add(node.getVal());

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            ret.add(level);
        }

        return ret;
    }



}
