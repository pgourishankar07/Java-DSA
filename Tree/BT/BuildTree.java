import java.util.HashMap;

public class BuildTree { // using preOrder and PostOrder

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            val = 0;
            left = null;
            right = null;
        }

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        private HashMap<Integer, Integer> postOrderIndexMap = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                postOrderIndexMap.put(postorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                int[] postorder, int postStart, int postEnd) {

            if (preStart > preEnd)
                return null;

            TreeNode root = new TreeNode(preorder[preStart]);

            if (preStart == preEnd)
                return root;

            int leftRootIndex = postOrderIndexMap.get(preorder[preStart + 1]);
            int leftSubtreeLength = leftRootIndex - postStart + 1;

            root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeLength,
                    postorder, postStart, leftRootIndex);

            root.right = buildTree(preorder, preStart + leftSubtreeLength + 1, preEnd,
                    postorder, leftRootIndex + 1, postEnd - 1);

            return root;
        }
    }

    //
    public TreeNode buildPreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // create node
        TreeNode root = new TreeNode(preorder[preStart]);

        // find left and right subtree using inorder array
        int inRootIdx = inMap.get(root.val);
        int numsLeft = inRootIdx - inStart; // remaining elemets in left and right subtree

        // splitting the arrays
        root.left = buildPreIn(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRootIdx - 1, inMap);
        root.right = buildPreIn(preorder, preStart + numsLeft + 1, preEnd, inorder, inRootIdx + 1, inEnd, inMap);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode res = buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return res;
    }

    //
    public TreeNode buildPostIn(int[] postorder, int posStart, int posEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {

        if (posStart > posEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[posEnd]);

        int inRootIdx = inMap.get(root.val);
        int numsLeft = inRootIdx - inStart;

        root.left = buildPostIn(postorder, posStart, posStart + numsLeft - 1, inorder, inStart, inRootIdx - 1, inMap);
        root.right = buildPostIn(postorder, posStart + numsLeft, posEnd - 1, inorder, inRootIdx + 1, inEnd, inMap);

        return root;
    }
}
