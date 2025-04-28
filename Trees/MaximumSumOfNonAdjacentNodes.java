
class Solution {
    static class Pair{
        int include, exclude;
        Pair(int include, int exclude){
            this.include = include;
            this.exclude = exclude;
        }
    }
    // Function to return the maximum sum of non-adjacent nodes.
    public int getMaxSum(Node root) {
        // code here
        Pair result = helper(root);
        return Math.max(result.include, result.exclude);
    }
    
    private Pair helper(Node root){
        if(root == null) return new Pair(0,0);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int include = root.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include,left.exclude) + Math.max(right.include, right.exclude);
        
        return new Pair(include, exclude);
    }
}
