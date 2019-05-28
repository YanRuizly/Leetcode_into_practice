package LeetCode.Top100;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class LeetCode105 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0 ||
                preorder.length != inorder.length){
            return null;
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    /**
     * pStart、pEnd 当前树的前序数组开始和结束位置
     * iStart、iEnd：中序数组开始和结束位置
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        for (int i = iStart;i <= iEnd;i++){
            if (preorder[pStart] == inorder[i]){
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                // 左子树
                root.left = buildTree(preorder,inorder,pStart+1,pStart+(i-iStart),iStart,i-1);
                // 右子树
                root.right = buildTree(preorder,inorder,(i - iStart)+pStart+1,pEnd,i+1,iEnd);
            }
        }
        return root;
    }
}
