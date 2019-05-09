package LeetCode.Top100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * @author YANRUI
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        doCombination(candidates,target,0,list,lists);
        return lists;
    }

    public void doCombination(int[] candidates, int target,int start,List<Integer> list,List<List<Integer>> lists) {
        if(target == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target < candidates[0])
            return;
        for(int i=start;i<candidates.length;i++){
            if(target >= candidates[i]){
                list.add(candidates[i]);
                doCombination(candidates,target-candidates[i],i,list,lists);
                list.remove(list.size()-1);
            }
        }

    }
}
