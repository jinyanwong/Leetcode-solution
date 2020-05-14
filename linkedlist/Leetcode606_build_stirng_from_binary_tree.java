package Leetcode_solution;

import java.util.HashSet;
import java.util.Stack;

/**
 * blog : https://jinyanwong.blog.csdn.net/article/details/106113458
 *
 * @author jinyanwong
 */
public class Leetcode606_build_stirng_from_binary_tree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static String solutionRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        if(root.right == null){
            if(root.left == null)
                return String.valueOf(root.val);
            else
                return root.val
                        + "("
                        + solutionRecursive(root.left)
                        + ")";
        }        

        // root.left != null && root.right != null
        return root.val
                + "("
                + solutionRecursive(root.left)
                + ")("
                + solutionRecursive(root.right)
                + ")";

    }

    public static String solutionIterative(TreeNode root){
        if(root == null) return "";
        
        StringBuilder res = new StringBuilder();
        HashSet<TreeNode> visitedSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(visitedSet.contains(node)){
                res.append(")");
                stack.pop();
            }else{
                visitedSet.add(node);
                res.append("(" + node.val);
                
                if(node.left == null && node.right != null)                       
                    res.append("()");
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                     stack.push(node.left);                
                
            }
        }
        return res.substring(1, res.length() - 1);
        
        
    }
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(1);
//        TreeNode two = head.left = new TreeNode(2);
//        TreeNode three = head.right = new TreeNode(3);
//        TreeNode four = two.left = new TreeNode(4);

        TreeNode head = new TreeNode(1);
        TreeNode two = head.left = new TreeNode(2);
        TreeNode three = head.right = new TreeNode(3);
        TreeNode four = two.right = new TreeNode(4);

        String res = solutionIterative(head);
        System.out.printf("result: %s\n\n", res);

    }
}
