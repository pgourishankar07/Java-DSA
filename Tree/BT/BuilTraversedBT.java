import java.util.ArrayList;
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

        // build BT from preOrder Sequence
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

        // preOrder Traversal
        public void preorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            System.out.println(root.val);
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }

        // inOrder Traversal
        public void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraverse(root.left);
            System.out.println(root.val);
            inorderTraverse(root.right);
        }

        // postOrder Traversal
        public void postorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            postorderTraverse(root.left);
            postorderTraverse(root.right);
            System.out.println(root.val);
        }

        // Level Order Traversal
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

        // Reverse Level Order Traversal
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

        // Height of a Tree
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Count Nodes in a Tree
        public int count(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftCount = count(root.left);
            int rightCount = count(root.right);

            return leftCount + rightCount + 1;
        }

        // Sum of Nodes in a Tree
        public int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);

            return leftSum + rightSum + root.val;
        }

        // Diameter of the tree
        public int diameter(TreeNode root) { // O(N^2)
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int righttHeight = height(root.right);

            int leftDia = diameter(root.left);
            int rightDia = diameter(root.right);

            int selfDia = leftHeight + righttHeight + 1;

            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        // Diameter Optimized using class and object (calculating both height and
        // diameter in 1 go)
        static class Info {
            int dia;
            int ht;

            Info() {
            }

            Info(int dia, int ht) {
                this.dia = dia;
                this.ht = ht;
            }
        }

        public Info diameterOpt(TreeNode root) {
            if (root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameterOpt(root.left);
            Info rightInfo = diameterOpt(root.right);

            int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(dia, ht);
        }

        // Check a subTree is present in a Tree
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

        // Top View of the Tree
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

        // Bottom view of the tree
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

        // Left View of the Tree
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

        // Right View of the Tree
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

        System.out.println("PreOrder Traversal :");
        bt.preorderTraverse(root);

        System.out.println("InOrder Traversal :");
        bt.inorderTraverse(root);

        System.out.println("PostOrder Traversal :");
        bt.postorderTraverse(root);

        System.out.println("LevelOrder Traversal :");
        bt.levelOrderTraversal(root);

        System.out.println("Reverse LevelOrder Traversal :");
        bt.RevlevelOrderTraversal(root);

        System.out.println("Height of a Tree  : " + bt.height(root));
        System.out.println("Number of Nodes : " + bt.count(root));
        System.out.println("Sum Of Nodes : " + bt.sum(root));

        System.out.println("Diameter of the Tree : " + bt.diameter(root));

        System.out.println("Diameter of the Tree (Optimized): " + bt.diameterOpt(root).dia);

        System.out.println(" __________________________________________________________");
        int nodes2[] = { 3, -1, 6, -1, -1 };

        BinaryTree bt2 = new BinaryTree();
        TreeNode root2 = bt2.preorderBuild(nodes2);

        System.out.println("SubTree is Present in the Tree : " + bt.isSubTree(root, root2));

        bt.topView(root);
        bt.bottomView(root);
        bt.leftView(root);
        bt.rightView(root);

        bt.kthLevel(root, 3);
    }
}
