package casia.isiteam.Trie;

import casia.isiteam.Trie.vo.TreeNode;

import java.net.Socket;
import java.util.*;

/**
 * @ClassName: Test
 * @Description: 前中后序遍历
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/8
 * Email: zhiyou_wang@foxmail.com
 */
public class TraversalTest {

    public static void main(String[] args) {
        TraversalTest test = new TraversalTest();
        //初始化二叉树
        TreeNode treeNode = test.init();

        //验证二叉搜索树
        boolean isValidBST = test.isValidBST(treeNode);
        System.out.println("是否为二叉搜索树："+isValidBST);

        //二叉树-前序遍历
        test.preorderTraversal(treeNode);
        //二叉树-中序遍历
        test.inorderTraversal(treeNode);
        //二叉树-后序遍历
        test.postorderTraversal(treeNode);
        //二叉树-层序遍历
        test.levelOrder(treeNode);
        //二叉树- 是否对称
        test.isSymmetric(treeNode);

        //二叉树- 反转
        TreeNode t = treeNode;
        TreeNode rs = test.invertTree(t);
        System.out.print("反转结果：");test.levelOrder(rs);//层序遍历打印反转结果

        //二叉树- 路径总和 等于 给定目标值
        boolean asPathSum = test.hasPathSum(treeNode,10);//堆队列,迭代方式
        boolean asPathSum2 = test.hasPathSum2(treeNode,10);//递归方式
        System.out.println("路径总和："+asPathSum+"\t"+asPathSum2);

        //二叉搜索树中的搜索
        TreeNode searchBST = test.searchBST(treeNode,2);
        System.out.print("搜索结果：");test.levelOrder(searchBST);//层序遍历打印搜索结果

        //二叉搜索树中的插入操作
        TreeNode insertIntoBST = test.insertIntoBST(treeNode,8);
        System.out.print("插入结果：");test.levelOrder(insertIntoBST);//层序遍历打印插入结果


    }
    /**
     * 初始化一个trie
     *     1
     *     \
     *      2
     *     / \
     *    3   6
     *   / \   \
     *  5   4   7
     *
     * */
    public TreeNode init(){
//        TreeNode treeNode3 = new TreeNode(3,new TreeNode(4),new TreeNode(4));
        TreeNode treeNode = new TreeNode(3,new TreeNode(5),new TreeNode(4));
        TreeNode treeNode2 = new TreeNode(2,treeNode,new TreeNode(6,null,new TreeNode(7)));
        TreeNode treeNode3 = new TreeNode(1,null,treeNode2);
        System.out.println(
                "初始化一个trie\n" +
                "    1\n" +
                "     \\\n" +
                "      2\n" +
                "     / \\\n" +
                "    3   6\n" +
                "   / \\   \\\n" +
                "  5   4   7"
        );
        return treeNode3;
    }

    /**
     * 二叉树前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode old = root;
        while(old!=null || !stack.isEmpty()){
            if(old!=null){
                rs.add(old.val);
                stack.push(old);
                old = old.left;
            }else{
                old = stack.pop();
                old = old.right;
            }
        }

        //打印
        System.out.println("前序遍历："+rs);
        return rs;
    }
    /**
     * 二叉树中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode old = root;
        while(old!=null || !stack.isEmpty()){
            if(old!=null){
                stack.push(old);//压入堆栈
                old = old.left;
            }else{
                old = stack.pop();//获取堆栈顶部对象
                rs.add(old.val);
                old = old.right;
            }
        }
        //打印
        System.out.println("中序遍历："+rs);
        return rs;
    }
    /**
     * 二叉树后续遍历
     * @param root
     * @return
     *
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode old = root, p = null;
        while(old!=null || !stack.isEmpty()){
            if(old!=null){
                stack.push(old);
                old = old.left;
            }else{
                old = stack.peek();
                if( old.right == null || old.right == p ){
                    rs.add(old.val);
                    p = old;
                    stack.pop();
                    old = null;
                }else{
                    old = old.right;
                }
            }
        }
        //打印
        System.out.println("后序遍历："+rs);
        return rs;
    }

    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if( root == null ){
            return  null;
        }
        List<List<Integer>> rs = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }
            rs.add(itemList);
        }

        //打印
        System.out.println("层序遍历："+rs);
        return rs;
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int level = 0;
        if( root == null ){
            return level;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int i = queue.size();
            while(i>0){
                TreeNode treeNode= queue.poll();
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                i--;
            }
            level++;
        }
        //打印
        System.out.println("最大深度："+level);
        return level;
    }

    /**
     * 二叉树 是否对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        boolean rs = isSymmetric(root.left,root.right);
        //打印
        System.out.println("二叉树是否对称："+rs);
        return rs;
    }
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if( left!=null && right==null  ){return false;}
        if( left==null && right!=null  ){return false;}
        if (left == null && right == null) {return true;}
        if( left.val != right.val ){return false;}
        // 比较外侧
        boolean rs1= isSymmetric(left.left,right.right);
        // 比较内侧
        boolean rs2= isSymmetric(left.right,right.left);
        return rs1 && rs2;
    }

    /**
     * 二叉树 反转
     * @param root
     * @return
     * DFS递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }
    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**
     * 二叉树 路径和
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){return false;}
        Stack<TreeNode> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);

        while (!stack1.isEmpty()){
            int ii = stack1.size();
            for(int i=0;i<ii;i++){
                TreeNode treeNode = stack1.pop();
                int sum = stack2.pop();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(treeNode.left==null && treeNode.right==null && sum==targetSum)return true;
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(treeNode.right!=null){
                    stack1.push(treeNode.right);stack2.push(sum+treeNode.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(treeNode.left!=null){
                    stack1.push(treeNode.left);stack2.push(sum+treeNode.left.val);
                }
            }
        }
        return false;
    }
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root==null){return false;}
        int tar = targetSum - root.val;
        if( root.left==null && root.right==null){
            return tar==0;
        }
        if( root.left != null ){
            boolean left= hasPathSum2(root.left,tar);
            if (left) {// 已经找到
                return true;
            }
        }
        if( root.right != null ){
            boolean right = hasPathSum2(root.right,tar);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }

    /**
     * 二叉树 查找
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){return root;}
        if( root.val == val ){
            return root;
        }
        if( root.left != null ){
            TreeNode treeNode = searchBST(root.left, val);
            if( treeNode!=null ){
                return treeNode;
            }
        }
        if( root.right !=null ){
            TreeNode treeNode = searchBST(root.right, val);
            if( treeNode!=null ){
                return treeNode;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树的 插入操作
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if( root == null ){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        } else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    /**
     * 二叉搜索树 验证
     * @param root
     * @return
     */
    private long val = Long.MIN_VALUE;
    private int count = 0;
    public boolean isValidBST(TreeNode root) {
        if( root == null ){
            return true;
        }
        isValidBST(root.left);
        if( root.val <= val ){
            count++;
        }
        val = root.val;
        isValidBST(root.right);

        return count==0;
    }
}
