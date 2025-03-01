import java.util.*;

public class MaxFarmArea {
    static int maxArea = 0;
    static int currentArea = 0;

    public static int maxAreaOfFarm(int[][] grid) {
        maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    currentArea = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return maxArea;
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0; 
        currentArea++;  
        maxArea = Math.max(maxArea, currentArea); 

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 1},
            {1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0}
        };
        System.out.println(maxAreaOfFarm(grid)); // Output: 7
    }
}
