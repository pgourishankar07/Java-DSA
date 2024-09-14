import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AssignmentQ {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }

    }

    static class BinaryTree {
        int idx = -1;

        public TreeNode preorderBuild(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = preorderBuild(nodes);
            newNode.right = preorderBuild(nodes);

            return newNode;
        }

        public void levelOrderTraversal(TreeNode root) {

            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {

                TreeNode temp = q.remove();
                System.out.println(temp.val);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            System.out.println();
        }

        public boolean univalue(TreeNode root, int n) {
            if (root == null) {
                return true;
            }

            if (root.val != n) {
                return false;
            }

            return univalue(root.left, n) && univalue(root.right, n);
        }

        public TreeNode invertBT(TreeNode root) {
            if (root == null) {
                return null;
            }

            // first build left and right side for a node
            TreeNode left = invertBT(root.left);
            TreeNode right = invertBT(root.right);

            // second assign the left side as right(vice versa)
            root.left = right;
            root.right = left;

            return root;
        }

        public String isDupli(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
            if (root == null) {
                return "N";
            }

            String s = Integer.toString(root.val) + "," + isDupli(root.left, map, list) + ","
                    + isDupli(root.right, map, list); // converting the order to string (any order - in,pre,post)

            if (map.get(s) == 1) { // checking that order hsa occured before or not
                list.add(root);
            }

            map.put(s, map.getOrDefault(s, 0) + 1);

            return s;
        }

        public int maxPath(TreeNode root, int[] maxVal) {
            if (root == null) {
                return 0;
            }

            int left = maxPath(root.left, maxVal);
            int right = maxPath(root.right, maxVal);

            maxVal[0] = Math.max(maxVal[0], left + right + root.val);

            return Math.max(left, right) + root.val;
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 2, 5, 3, -1, -1, 6, -1, -1, 7, -1, 8, -1, -1 };
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.preorderBuild(nodes);
        bt.levelOrderTraversal(root);

        // System.out.println(bt.univalue(root, root.val));

    }
}
