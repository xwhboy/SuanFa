import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by xwh12 on 2016/8/13.
 */
public class LevelTravel {
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Queue q1 = new LinkedList();
        Queue q2 = new LinkedList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        q1.add(root);

        while(!q1.isEmpty() || !q2.isEmpty()){

            while(!q1.isEmpty()){
                TreeNode temp = (TreeNode)q1.poll();
                list.add(temp.val);
                if(temp.left != null) q2.add(temp.left);
                if(temp.right != null) q2.add(temp.right);
            }
            if(list.size() > 0)result.add(new ArrayList<Integer>(list));
            list.clear();
            while(!q2.isEmpty()){
                TreeNode temp = (TreeNode)q2.poll();
                list.add(temp.val);
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
            }
            if(list.size() > 0)result.add(new ArrayList<Integer>(list));
            list.clear();
        }
        return result;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}



//public class Solution {
//    /**
//     * @param root: The root of binary tree.
//     * @return: Level order a list of lists of integer
//     */
//    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
//        // write your code here
//
//        if(root==null)
//        {
//            System.out.println("error");
//        }
//        ArrayList<ArrayList<Integer>> aa=new  ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> al=new ArrayList<Integer>();;
//        List<TreeNode> queue=new LinkedList<TreeNode>();
//        queue.add(root);
//        int level=0,tempc=0;
//        while(!queue.isEmpty()){
//            TreeNode temp=queue.remove(0);
//
//            al.add(temp.val);
//
//
//            if(temp.left!=null){
//                queue.add(temp.left);
//            }
//            if(temp.right!=null){
//                queue.add(temp.right);
//            }
//
//        }
//        aa.add(al);
//        return aa;
//    }
//}



