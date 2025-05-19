 class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // Create ArrayList to store predecessor and successor
        ArrayList<Node> result = new ArrayList<>();
        
        // Initialize predecessor and successor as null
        Node pre = null;
        Node suc = null;
        
        // Perform inorder traversal to get sorted list
        ArrayList<Node> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        
        // Find predecessor and successor using the sorted list
        for (int i = 0; i < inorder.size(); i++) {
            // If current node's data equals key, set predecessor and successor
            if (inorder.get(i).data == key) {
                if (i > 0) pre = inorder.get(i - 1);
                if (i < inorder.size() - 1) suc = inorder.get(i + 1);
                break;
            }
            // If current node's data is greater than key, set successor and break
            else if (inorder.get(i).data > key) {
                suc = inorder.get(i);
                if (i > 0) pre = inorder.get(i - 1);
                break;
            }
            // If we reach the end, set only predecessor
            else if (i == inorder.size() - 1) {
                pre = inorder.get(i);
            }
        }
        
        // Add predecessor and successor to result
        result.add(pre);
        result.add(suc);
        
        return result;
    }
    
    // Helper function to perform inorder traversal
    private void inorderTraversal(Node root, ArrayList<Node> inorder) {
        if (root == null) return;
        
        inorderTraversal(root.left, inorder);
        inorder.add(root);
        inorderTraversal(root.right, inorder);
    }
}
