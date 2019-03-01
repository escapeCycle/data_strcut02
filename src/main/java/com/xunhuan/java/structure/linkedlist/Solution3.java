package com.xunhuan.java.structure.linkedlist;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * @author tianhuan
 * @date 2018-12-10 16:56
 **/
public class Solution3 {
    List<List<Double>> ans;
    public List<List<Double>> combinationSum2(double[] candidates, double target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        track(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    private void track(double[] candidates, int index, double target, List<Double> list) {
        if (target == 0) {
            ans.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i] || (i > index && candidates[i] == candidates[i - 1])){
                continue;
            }
            List<Double> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            track(candidates, i + 1, target - candidates[i], temp);
        }
    }


    private Map<Integer, Set<List<Integer>>> map = new HashMap<Integer, Set<List<Integer>>>();
    public List<List<Integer>> combinationSum3(int[] num, int target)
    {
        Set<List<Integer>> tl = new HashSet<List<Integer>>();
        tl.add(new ArrayList<Integer>());
        map.put(0, tl);
        Arrays.sort(num);
        for(int i : num)
        {
            if(i>target){
                break;
            }
            List<Integer> tmp = new ArrayList<Integer>(map.keySet());
            Collections.sort(tmp, Collections.reverseOrder());
            for(int k : tmp)
            {
                if(k+i<=target)
                {
                    Set<List<Integer>> list = map.get(k);
                    Set<List<Integer>> newList;
                    if(map.containsKey(k+i)){
                        newList = map.get(k+i);
                    }
                    else{
                        newList = new HashSet<List<Integer>>();
                    }
                    for(List<Integer> subList : list)
                    {
                        List<Integer> nl = new ArrayList<Integer>(subList);
                        nl.add(i);
                        newList.add(nl);
                    }
                    map.put(k+i,newList);
                }
            }
        }
        if(map.containsKey(target)){
            return new ArrayList<List<Integer>>(map.get(target));
        }else{
            return new ArrayList<List<Integer>>();
        }
    }




    public double getRandomD(){
        /*
           最小值
         */
        double min = 0.01;
        /*
            最大数
         */
        double max = 1000;
        /*
            小数最大位数
         */
        int scl =  2;
        /*
            指定小数位
         */
        int pow = (int) Math.pow(10, scl);
        return Math.floor((Math.random() * (max - min) + min) * pow) / pow;
    }

    public int getRandomI(){
        Random random = new Random();
        return random.nextInt(1000)+1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        double[] randomArr = new double[700];
//        for(int i = 0;i<randomArr.length;i++){
//            randomArr[i] = solution3.getRandomD();
//        }
//
//        double[] a = new double[]{1.22,2.22,5.50,8.78,23.22,1.11,23,1.33,2,32.21,1.33};
//        Instant start = Instant.now();
//        List<List<Double>> lists = solution3.combinationSum2(randomArr, 255.55);
//        System.out.println(lists);
//
//        Instant end = Instant.now();
//        System.out.println("耗费时间ms: "+ Duration.between(start,end).toMillis());

        int[] randomArrI = new int[10000];
        for(int i = 0;i<randomArrI.length;i++){
            randomArrI[i] = solution3.getRandomI();
        }
        Instant start1 = Instant.now();
        List<List<Integer>> lists1 = solution3.combinationSum3(randomArrI, 65);
        System.out.println(lists1);

        Instant end1 = Instant.now();
        System.out.println("耗费时间ms: "+ Duration.between(start1,end1).toMillis());
    }
}
