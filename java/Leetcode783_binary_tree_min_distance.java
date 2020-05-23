package Leetcode_solution;


/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106295935
 *
 * @author jinyanwong
 */
public class Leetcode783_binary_tree_min_distance {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int solutionRecursive(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return Integer.MAX_VALUE;
        }
    
//        int i1 = root.left == null ? Integer.MAX_VALUE : root.val - root.left.val;
//        int i2 = root.right == null ? Integer.MAX_VALUE : root.right.val - root.val;
//        
//        int i3 = solutionRecursive(root.left);
//        int i4 = solutionRecursive(root.right);
//        
//        return Math.min(Math.min(i1, i2), Math.min(i3, i4));
        
        return Math.min(Math.min((root.left == null ? Integer.MAX_VALUE 
                                    : root.val - root.left.val), 
                                 (root.right == null ? Integer.MAX_VALUE 
                                    : root.right.val - root.val)),
                        Math.min(solutionRecursive(root.left), 
                                 solutionRecursive(root.right))
                        );

    }
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(4);
//        TreeNode two = head.left = new TreeNode(2);
//        TreeNode three = head.right = new TreeNode(6);
//        TreeNode four = two.left = new TreeNode(1);

        TreeNode head = new TreeNode(465);
        TreeNode two = head.left = new TreeNode(200);
        TreeNode three = head.right = new TreeNode(500);
        TreeNode four = two.left = new TreeNode(100);
        TreeNode five = two.right = new TreeNode(300);
        
        int res = solutionRecursive(head);
        System.out.printf("result: %d\n\n", res);

    }
}
