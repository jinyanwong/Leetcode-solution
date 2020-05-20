package Leetcode_solution;

/*
* BLOG : https://jinyanwong.blog.csdn.net/article/details/106240201
* @author jinyanwong
*/
public class Leetcode100_same_tree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this(x, null, null);
        }
        
        TreeNode(int x, TreeNode _left, TreeNode _right){
            val = x;
            left = _left;
            right = _right;
        }
    }

    public static boolean solutionRecursive(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;        
        
        else if(root1 != null && root2 != null){
            return root1.val == root2.val 
                    && solutionRecursive(root1.left, root2.left)
                    && solutionRecursive(root1.right, root2.right);
        }
        else return false;
        
    }

    public static void main(String[] args) {

        // ------------> treeA
        TreeNode treeA = new TreeNode(1);
        TreeNode twoA = treeA.left = new TreeNode(2);
        TreeNode threeA = treeA.right = new TreeNode(1);


        // ------------->treeB
        TreeNode treeB = new TreeNode(1);
        TreeNode twoB = treeB.left = new TreeNode(1);
        TreeNode threeB = treeB.right = new TreeNode(2);
        
        
        boolean res = solutionRecursive(treeA, treeB);
        System.out.printf("\nOnput:%b", res );
        

    }
}
