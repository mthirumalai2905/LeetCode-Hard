class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int mx = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            mx = Math.max(mx, rectangleArea(heights));
        }
        
        return mx;
    }
    private int rectangleArea(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int mx = 0;
        for(int i = 0; i < n; ++i){
            int width = right[i] - left[i] - 1;
            mx = Math.max(mx, heights[i] * width);
        }
        return mx;
    }
}
