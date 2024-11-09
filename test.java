/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void bfs(TreeNode root, HashMap<TreeNode, TreeNode> map, Queue<TreeNode> q) {
        if (root == null) {
            return;
        }

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp.left != null) {
                q.add(temp.left);
                map.put(temp.left, temp);
            }
            if (temp.right != null) {
                q.add(temp.right);
                map.put(temp.right, temp);
            }
        }

    }

    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map, List<Integer> res, HashSet<Integer> set) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        bfs(root, map, q);

        HashSet<Integer> set = new HashSet<>();
        dfs(root, map, res, set);

        return res;
    }
}