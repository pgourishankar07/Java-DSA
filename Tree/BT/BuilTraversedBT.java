import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuilTraversedBT {

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

        // build BT from preOrder
        // Sequence____________________________________________________________________________________________________________
        public TreeNode preorderBuild(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = preorderBuild(nodes);
            newNode.right = preorderBuild(nodes);

            return newNode;
        }

        // preOrder
        // Traversal____________________________________________________________________________________________________________
        public void preorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            System.out.print(root.val + " ");
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }

        // inOrder
        // Traversal____________________________________________________________________________________________________________
        public void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraverse(root.left);
            System.out.print(root.val + " ");
            inorderTraverse(root.right);
        }

        // postOrder
        // Traversal____________________________________________________________________________________________________________
        public void postorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            postorderTraverse(root.left);
            postorderTraverse(root.right);
            System.out.print(root.val + " ");
        }

        // Level Order
        // Traversal____________________________________________________________________________________________________________
        public void levelOrderTraversal(TreeNode root) {

            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {

                TreeNode temp = q.remove();

                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        System.out.println();
                        q.add(null);
                    }
                } else {
                    System.out.print(temp.val + " ");
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
            System.out.println();
        }

        // Reverse Level Order
        // Traversal____________________________________________________________________________________________________________
        public void RevlevelOrderTraversal(TreeNode root) {

            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {

                TreeNode temp = q.remove();

                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        System.out.println();
                        q.add(null);
                    }
                } else {
                    System.out.print(temp.val + " ");
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                }
            }
            System.out.println();
        }

        // ZIgZag LevelOrder
        // traversal____________________________________________________________________________________________________________
        public void zigZag(TreeNode root) {
            if (root == null) {
                return;
            }

            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            boolean flag = false;

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.remove();
                    list.add(temp.val);

                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }

                if (flag) {
                    Collections.reverse(list);
                }
                flag = !flag;
                res.add(list);
            }
            for (List<Integer> i : res) {
                System.out.println(i);
            }
        }

        // Height of a
        // Tree____________________________________________________________________________________________________________
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Count Nodes in a
        // Tree____________________________________________________________________________________________________________
        public int count(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftCount = count(root.left);
            int rightCount = count(root.right);

            return leftCount + rightCount + 1;
        }

        // Sum of Nodes in a
        // Tree____________________________________________________________________________________________________________
        public int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);

            return leftSum + rightSum + root.val;
        }

        // Diameter of the
        // tree____________________________________________________________________________________________________________
        public int diameter(TreeNode root) { // O(N^2)
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int righttHeight = height(root.right);

            int selfDia = leftHeight + righttHeight + 1;

            int leftDia = diameter(root.left);
            int rightDia = diameter(root.right);

            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        // Diameter Optimized using class and object (calculating both height and
        // diameter in 1 go)
        // static

        record Info(int dia, int ht) {
        }

        public Info diameterOpt(TreeNode root) {
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameterOpt(root.left);
            Info rightInfo = diameterOpt(root.right);

            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            int dia = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.dia, rightInfo.dia));

            return new Info(dia, ht);
        }

        // Check a subTree is present in a
        // Tree____________________________________________________________________________________________________________
        public boolean isSame(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            } else if (root == null || subRoot == null || root.val != subRoot.val) {
                return false;
            }

            if (!isSame(root.left, subRoot.left) || !isSame(root.right, subRoot.right)) {
                return false;
            }

            return true;
        }

        public boolean isSubTree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }

            if (root.val == subRoot.val) {
                if (isSame(root, subRoot)) {
                    return true;
                }
            }

            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

        // Top View of the
        // Tree____________________________________________________________________________________________________________
        static class Info2 {
            TreeNode node;
            int horDis;

            Info2() {
            }

            Info2(TreeNode node, int horDis) {
                this.node = node;
                this.horDis = horDis;
            }
        }

        public void topView(TreeNode root) {

            if (root == null) {
                return;
            }

            int min = 0;
            int max = 0;
            Queue<Info2> q = new LinkedList<>();
            HashMap<Integer, TreeNode> map = new HashMap<>();

            q.add(new Info2(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info2 temp = q.remove();
                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(temp.horDis)) {
                        map.put(temp.horDis, temp.node);
                    }

                    if (temp.node.left != null) {
                        q.add(new Info2(temp.node.left, temp.horDis - 1));
                        min = Math.min(temp.horDis - 1, min);
                    }
                    if (temp.node.right != null) {
                        q.add(new Info2(temp.node.right, temp.horDis + 1));
                        max = Math.max(temp.horDis + 1, max);
                    }

                }
            }

            System.out.println("Top View of the Tree : ");

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).val + " ");
            }

            System.out.println();
        }

        // Bottom view of the
        // tree____________________________________________________________________________________________________________
        public void bottomView(TreeNode root) {

            if (root == null) {
                return;
            }

            int min = 0;
            int max = 0;
            Queue<Info2> q = new LinkedList<>();
            HashMap<Integer, TreeNode> map = new HashMap<>();

            q.add(new Info2(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info2 temp = q.remove();
                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    map.put(temp.horDis, temp.node);

                    if (temp.node.left != null) {
                        q.add(new Info2(temp.node.left, temp.horDis - 1));
                        min = Math.min(temp.horDis - 1, min);
                    }
                    if (temp.node.right != null) {
                        q.add(new Info2(temp.node.right, temp.horDis + 1));
                        max = Math.max(temp.horDis + 1, max);
                    }

                }
            }

            System.out.println("Bottom View of the Tree : ");

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).val + " ");
            }
            System.out.println();
        }

        // Left View of the
        // Tree____________________________________________________________________________________________________________
        public void leftView(TreeNode root) {
            if (root == null) {
                return;
            }

            List<Integer> arr = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            arr.add(q.peek().val);

            while (!q.isEmpty()) {

                TreeNode temp = q.remove();

                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        arr.add(q.peek().val);
                        q.add(null);
                    }
                } else {
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }

            System.out.println("Right View of Binary Tree : ");

            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Right View of the
        // Tree____________________________________________________________________________________________________________
        public void rightView(TreeNode root) {
            if (root == null) {
                return;
            }

            List<Integer> arr = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            arr.add(q.peek().val);

            while (!q.isEmpty()) {

                TreeNode temp = q.remove();

                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        arr.add(q.peek().val);
                        q.add(null);
                    }
                } else {
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                }
            }

            System.out.println("Left View of Binary Tree : ");

            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Nodes at the Kth
        // level____________________________________________________________________________________________________________
        public void kthLevel(TreeNode root, int k) {

            if (root == null || k == 0) {
                return;
            }

            int lvl = 0;
            // List<Integer> arr = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            // arr.add(q.peek().val);
            lvl++;

            while (!q.isEmpty()) {

                if (lvl == k) {
                    break;
                }

                TreeNode temp = q.remove();
                if (temp == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                        lvl++;
                    }
                } else {
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }

            System.out.println("Nodes in the Level " + k + " : ");

            while (q.peek() != null) {
                System.out.print(q.remove().val + " ");
            }
            System.out.println();

        }

        // Get Path from the rootnode to the given
        // node____________________________________________________________________________________________________________
        public boolean getPath(TreeNode root, int n, List<Integer> list) {
            if (root == null) {
                return false;
            }

            list.add(root.val);

            if (root.val == n) {
                return true;
            }

            if (getPath(root.left, n, list) || getPath(root.right, n, list)) {
                return true;
            } else {
                list.remove(list.size() - 1);
                return false;
            }
        }

        // Lowest Common
        // Ancestor____________________________________________________________________________________________________________
        public void lca(TreeNode root, int n1, int n2) {
            if (root == null) {
                return;
            }

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            getPath(root, n1, list1);
            getPath(root, n2, list2);

            if (list1.get(0) != list2.get(0)) {
                return;
            }

            int i = 0;
            while (i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)) {
                i++;
            }

            System.out.println("Lowest Common Ancestor of the given two Nodes is : " +
                    list1.get(i - 1));
        }

        public TreeNode lca2(TreeNode root, int n1, int n2) {
            if (root == null) {
                return null;
            }
            if (root.val == n1 || root.val == n2) {
                return root;
            }

            TreeNode leftLca = lca2(root.left, n1, n2); // check leftSubTree has the node
            TreeNode rightLca = lca2(root.right, n1, n2);// check rightSubTree has the node

            if (leftLca == null) {
                return rightLca;
            }

            if (rightLca == null) {
                return leftLca;
            }

            // if both found that means left and right or not null then send the root thats
            // the ancestor which has the both right and left val

            return root;
        }

        // Minimum Distance Between two
        // nodes____________________________________________________________________________________________________________
        public void minDis(TreeNode root, int n1, int n2) {
            if (root == null) {
                return;
            }

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            getPath(root, n1, list1);
            getPath(root, n2, list2);

            if (list1.get(0) != list2.get(0)) {
                return;
            }

            int i = 0;
            while (i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)) {
                i++;
            }

            int minDistance = (list1.size() - i) + (list2.size() - i);

            System.out.println("The Minimum Distance between two nodes : " + minDistance);

        }

        // Kth Ancestor of a
        // node____________________________________________________________________________________________________________
        public void kthAnces(TreeNode root, int n, int k) {

            if (root == null) {
                return;
            }

            List<Integer> list = new ArrayList<>();

            getPath(root, n, list);

            int res = list.size() - k - 1 < 0 ? -1 : list.get(list.size() - k - 1);

            System.out.println(k + "th Ancestor of the node is : " + res);
        }

        // transform to sum
        // Tree____________________________________________________________________________________________________________
        public int sumTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int lSum = sumTree(root.left);
            int rSum = sumTree(root.right);

            root.val = lSum + rSum + root.val;

            return root.val;

        }

        // Get the leaf Nodes
        // ___________________________________________________________________________________________
        public void leaf(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                list.add(root.val);
            }

            leaf(root.left, list);
            leaf(root.right, list);
        }

        // Get Left Leafs
        // ___________________________________________________________________________________________
        public void leftLeafs(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                list.add(root.val);
            }

            leftLeafs(root.left, list);
            leftLeafs(root.right, list);
        }

        // Diagnol
        // Traversal___________________________________________________________________________________________
        public void diagnolTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode temp = q.remove();

                while (temp != null) {
                    if (temp.left != null) {
                        q.add(temp.left);
                    }

                    System.out.print(temp.val + " ");

                    temp = temp.right;
                }

            }
            System.out.println();
        }

        // Boundry
        // Traversal___________________________________________________________________________________________
        public void boundryTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            List<Integer> list = new ArrayList<>();

            TreeNode root1 = root;

            // get left side exclude leaf node
            while (root1.left != null && root1.right != null) {
                list.add(root1.val);
                if (root1.left != null) {
                    root1 = root1.left;
                } else {
                    root1 = root1.right;
                }
            }

            root1 = root.right;

            // get right side exclude leaf node
            while (root1.left != null || root1.right != null) {
                list.add(root1.val);
                if (root1.right != null) {
                    root1 = root1.right;
                } else {
                    root1 = root1.left;
                }
            }

            // get leaf nodes
            leaf(root, list);

            System.out.println(list);
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        /*
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.preorderBuild(nodes);

        // System.out.println("PreOrder Traversal :");
        // bt.preorderTraverse(root);
        // System.out.println();

        // System.out.println("InOrder Traversal :");
        // bt.inorderTraverse(root);
        // System.out.println();

        // System.out.println("PostOrder Traversal :");
        // bt.postorderTraverse(root);
        // System.out.println();

        // System.out.println("LevelOrder Traversal :");
        // bt.levelOrderTraversal(root);

        // System.out.println("Reverse LevelOrder Traversal :");
        // bt.RevlevelOrderTraversal(root);

        // System.out.println("Height of a Tree : " + bt.height(root));
        // System.out.println("Number of Nodes : " + bt.count(root));
        // System.out.println("Sum Of Nodes : " + bt.sum(root));

        // System.out.println("Diameter of the Tree : " + bt.diameter(root));

        // System.out.println("Diameter of the Tree (Optimized): " +
        // bt.diameterOpt(root).dia);

        // System.out.println("
        // __________________________________________________________");
        // int nodes2[] = { 3, -1, 6, -1, -1 };

        // BinaryTree bt2 = new BinaryTree();
        // TreeNode root2 = bt2.preorderBuild(nodes2);

        // System.out.println("SubTree is Present in the Tree : " + bt.isSubTree(root,
        // root2));

        // bt.topView(root);
        // bt.bottomView(root);
        // bt.leftView(root);
        // bt.rightView(root);

        // bt.kthLevel(root, 3);

        // System.out.println(bt.lca2(root, 4, 5).val);

        // bt.minDis(root, 4, 6);

        // bt.kthAnces(root, 4, 3);

        // System.out.println(bt.sumTree(root));
        // System.out.println("ZigZag Traversal : ");
        // bt.zigZag(root);

        int nodes3[] = { 8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 5, 2, -1,
                -1, -1 };
        BinaryTree bt3 = new BinaryTree();
        TreeNode root3 = bt3.preorderBuild(nodes3);

        // System.out.println("Diagnol Traversal : ");
        // bt3.diagnolTraversal(root3);

        System.out.println("Boundry Traversal : ");
        bt3.boundryTraversal(root3);
    }
}
