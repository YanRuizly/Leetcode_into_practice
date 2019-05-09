package LeetCode.backtrack;

import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;

import java.util.ArrayList;
import java.util.List;

public class AllCombine {
    public static List<List<Integer>> combinationSum(int[] candidates) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=1;i<=candidates.length;i++)   //i表示长度
            doCombination(candidates,0,i,lists,new ArrayList<>());
        return lists;
    }

    public static void doCombination(int[] candidates,int start,int len,List<List<Integer>> lists,List<Integer> list){
        if(len == 0){
            if(!list.isEmpty())
              lists.add(new ArrayList<>(list));
            return;
        }
        if(start == candidates.length)
            return;

        List<Integer> temp = new ArrayList<>(list);
        temp.add(candidates[start]);
        doCombination(candidates, start + 1, len-1, lists, temp);
        temp.remove(temp.size() - 1);
        doCombination(candidates, start + 1, len-1, lists, temp);
    }

    public static void main(String[] args){
        List<List<Integer>> lists = combinationSum(new int[]{2,3,6,7});
        System.out.println(lists);
    }
}
