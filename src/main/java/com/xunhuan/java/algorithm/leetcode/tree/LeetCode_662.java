package com.xunhuan.java.algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianh
 * @description:
 * @date 2024/4/10 19:40
 */
public class LeetCode_662 {
    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(node.left, depth + 1, index * 2)
                        , dfs(node.right, depth + 1, index * 2 + 1))
        );
    }

}
