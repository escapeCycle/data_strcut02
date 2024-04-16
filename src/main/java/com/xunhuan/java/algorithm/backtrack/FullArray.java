package com.xunhuan.java.algorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tianh
 * @description: 全排列-回溯
 * @date 2021-02-04 17:50
 */
public class FullArray {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 退出条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不符合规则的(全排列不能有重复)
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        FullArray fullArray = new FullArray();
        System.out.println(String.format("%s", fullArray.permute(new int[]{2, 3, 1})));
    }
}
