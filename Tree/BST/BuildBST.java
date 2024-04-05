import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildBST {
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

    // Build BST______________________________________________
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder Traversal______________________________________________
    public static void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

    // Search a node in BST______________________________________________
    public TreeNode searchBST(TreeNode root, int val) { // o(H)

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            root = searchBST(root.left, val);
        } else {
            root = searchBST(root.right, val);
        }

        return root;

    }

    // Delete Node______________________________________________
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // for deleting leaf nodes
        if (root.val == key && root.left == null && root.right == null) {
            return null;
        }

        // for deleting nodes having only 1 child
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
        }

        // for deleting nodes having 2 child (replace with inOrder successor and deelete
        // the node)
        if (root.val == key && root.left != null && root.right != null) {
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }

            root.val = temp.val;
            root.right = deleteNode(root.right, root.val);
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;

    }

    // Print in Range______________________________________________
    public static void printInRange(TreeNode root, int low, int high) {

        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            printInRange(root.left, low, high);
            System.out.print(root.val + " ");
            printInRange(root.right, low, high);
        } else if (root.val < low) {
            printInRange(root.right, low, high);
        } else {
            printInRange(root.left, low, high);
        }

    }

    // Root to leaf Path______________________________________________
    public static void rootToLeaf(TreeNode root, TreeNode leaf, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.val == leaf.val) {
            System.out.println(list);
            return;
        }

        if (root.val > leaf.val) {
            rootToLeaf(root.left, leaf, list);
        } else {
            rootToLeaf(root.right, leaf, list);
        }

    }

    // Validate BST______________________________________________
    public static boolean sorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);

        return sorted(list);

    }

    // recursive method
    public static boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    // apnaCollege
    public static boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        } else if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
    }

    // Mirror a BST______________________________________________
    public static TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // sorted Array to Balanced BST______________________________________________
    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + ((high - low) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, low, mid - 1);
        root.right = buildTree(nums, mid + 1, high);

        return root;
    }

    // Convert BST to Balanced BST______________________________________________
    public TreeNode buildTree(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = buildTree(list, low, mid - 1);
        root.right = buildTree(list, mid + 1, high);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);

        TreeNode res = buildTree(list, 0, list.size() - 1);

        return res;
    }

    // presence of BST in BT
    public static boolean isBSTinBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean valid = isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);

        boolean leftHasBST = isBSTinBT(root.left);
        boolean rightHasBST = isBSTinBT(root.right);

        return valid || leftHasBST || rightHasBST;
    }

    // calculate size of the BST (No.of
    // Nodes)______________________________________________
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    // size of largest BST in BT
    // (myCode)______________________________________________
    public static int largBSTSize(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        boolean valid = isValidBST2(root, null, null);

        if (valid) {
            max[0] = Math.max(size(root), max[0]);
        }

        @SuppressWarnings("unused")
        int left = largBSTSize(root.left, max);
        @SuppressWarnings("unused")
        int right = largBSTSize(root.right, max);

        return max[0];

    }

    // (ApnacCollegeCode)
    static class Info1 {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info1(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static Info1 largBSTSize2(TreeNode root, int[] maxBST) {
        if (root == null) {
            return new Info1(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info1 leftInfo = largBSTSize2(root.left, maxBST);
        Info1 rightInfo = largBSTSize2(root.right, maxBST);

        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));

        if (root.val <= leftInfo.max || root.val >= rightInfo.min) {
            return new Info1(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST[0] = Math.max(maxBST[0], size);
            return new Info1(true, size, min, max);
        }

        return new Info1(false, size, min, max);

    }

    // Merge Two Arrays______________________________________________
    // Another method : 1.inorder list of both trees 2.merge two list and sort
    // 3.buildTree from sorted list
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return root1;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        // root1.val = root1.val + root2.val; // this is for adding duplicate values (if
        // ur tree contains duplicates)
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    // closest element in BST______________________________________________
    public static void closest(TreeNode root, int target) {

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);

        int closeEl = Integer.MAX_VALUE;
        int res = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            closeEl = Math.min(closeEl, Math.abs(target - list.get(i)));
            if (closeEl < Math.abs(target - list.get(i))) {
                res = i - 1;
                break;
            }

        }

        System.out.println("The Closest Element is :" + list.get(res) + " and the Difference is :" + closeEl);

    }

    // LCA______________________________________________
    public static void lca(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return;
        }

        List<Integer> list1 = new ArrayList<>();
        rootToLeaf(root, node1, list1);
        List<Integer> list2 = new ArrayList<>();
        rootToLeaf(root, node2, list2);

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

    public static TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lcaBST(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lcaBST(root.right, p, q);
        }

        return root;
    }

    // Ceil of a node in BST
    public static void ceil(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);

        for (Integer i : list) {
            if (i >= key) {
                System.out.println("Ceil of the given value in the BST is : " + i);
                break;
            }
        }
    }

    public static void ceil2(TreeNode root, int key) {
        int ceil = root.val;

        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                break;
            }

            if (root.val > key) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        System.out.println("Ceil of the given value in the BST is : " + ceil);
    }

    // Floor of a node in BST
    public static void floor(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);
        Collections.reverse(list);
        for (Integer i : list) {
            if (i <= key) {
                System.out.println("Floor of the given value in the BST is : " + i);
                break;
            }
        }
    }

    public static void floor2(TreeNode root, int key) {
        int floor = root.val;

        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                break;
            }

            if (root.val > key) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }
        System.out.println("Floor of the given value in the BST is : " + floor);
    }

    // Recover BST
    public static void recover(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        recover(root.left, list);
        root.val = list.remove(0);
        recover(root.right, list);
    }

    public void recoverTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);
        System.out.println(list);
        Collections.sort(list);

        recover(root, list);

    }

    // Succesor of a node.val
    public static void succ(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);

        for (Integer i : list) {
            if (i > key) {
                System.out.println("The Succesor of the given Node : " + i);
                break;
            }
        }
    }

    public static void succ2(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        int res = 0;
        while (root != null) {
            if (root.val <= key) {
                root = root.right;
            } else {
                res = root.val;
                root = root.left;
            }
        }

        System.out.println("The Succesor of the given Node : " + res);
    }

    // Predecessor of a node.val
    public static void pred(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);

        Collections.reverse(list);

        for (Integer i : list) {
            if (i < key) {
                System.out.println("The Predecessor of the given Node : " + i);
                break;
            }
        }
    }

    public static void pred2(TreeNode root, int key) {
        if (root == null) {
            return;
        }

        int res = 0;

        while (root != null) {
            if (root.val >= key) {
                root = root.left;
            } else {
                res = root.val;
                root = root.right;
            }
        }
        System.out.println("The Predecessor of the given Node : " + res);
    }

    public static void main(String args[]) {

        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        for (int i : values) {
            root = insert(root, i);
        }

        List<Integer> list = new ArrayList<>();
        // root = mirror(root);
        // inorderTraverse(root, list);
        // printInRange(root, 5, 12);
        System.out.println();
        // System.out.println(size(root));

        TreeNode root2 = new TreeNode(50);
        root2.left = new TreeNode(30);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(20);

        rootToLeaf(root, root.left.right, list);
        root2.right = new TreeNode(60);
        root2.right.left = new TreeNode(45);
        root2.right.right = new TreeNode(70);
        root2.right.right.left = new TreeNode(65);
        root2.right.right.right = new TreeNode(80);

        // int max[] = { 0 };
        // System.out.println(largBSTSize(root2, max));

        // int[] maxBST = { 0 };
        // Info1 rooot = largBSTSize2(root2, maxBST);

        // System.out.println("Largest BST in BT : " + maxBST[0]);

        // closest(root, 8);

        // ______________________________________________

        System.out.println(lcaBST(root, root.left.left, root.left.right).val);

        // ceil(root, 12);
        // ceil2(root, 12);
        // floor(root, 12);
        // floor2(root, 12);

        // succ(root, 12);
        // succ2(root, 12);
        // pred(root, 12);
        // pred2(root, 12);
    }
}
