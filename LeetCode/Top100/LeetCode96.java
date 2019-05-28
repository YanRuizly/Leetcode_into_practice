package LeetCode.Top100;

/**
 *  不同的二叉搜索树
 */
public class LeetCode96 {
    /**
     * Fn = 2(2n+1)/(n+2)Fn-1
     *
     * */
    public int numTrees(int n) {
        if(n <= 0)
            return 0;
        else if (n == 1){
            return 1;
        }else{
            return numTrees(n-1)*2*(2*n-1)/(n+1);
        }
    }

    /**
     *  G（n）长度为n的序列的唯一BST数
     *  F（i，n） 1 <= i <= n
     *  G(n) 的总数是F（i）使用每个数字i作为根的BST的总和
     *  G（n） = F（1，n） + F（2，n）+ ... + F（n,n）
     *  G(0) = 1 ,G(1) = 1;
     *  F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
     *  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     * */
    public int numTreesDp(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
