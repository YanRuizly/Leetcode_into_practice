package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39_2 {
 //   private static List<List<Integer>> ret;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        doCombination(candidates, target, 0,ret, new ArrayList<>());
        return ret;
    }

    private static void doCombination(int[] candidates, int target, int start,List<List<Integer>> ret, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                doCombination(candidates, target - candidates[i], i,ret, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> lists = combinationSum(new int[]{2,3,6,7},7);
        System.out.println(lists);
    }
}
