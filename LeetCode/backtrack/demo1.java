package LeetCode.backtrack;
import java.util.List;
import java.util.ArrayList;
public class demo1 {
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> backtrack(int[] a,int target,int i){
        while(i<a.length){
            list.add(a[i]);
            if(sum(list) == target)
                System.out.println(list);
            backtrack(a, target, ++i);
            list.remove(list.size()-1);
        }
        return list;
    }
    public static int sum(List<Integer> list){
        int sum = 0;
        for(int x:list)
            sum += x;
        return sum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {10,20,80,70};
        int target = 100;
        backtrack(a,target,0);
        //System.out.println(list);
    }
}
