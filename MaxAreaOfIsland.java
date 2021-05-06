/*
  Question Link : https://leetcode.com/problems/max-area-of-island/
  
  Approach 1
  
  1. Iterate through the grid
    a. for every 1's call getArea method
    b. retain max of every 1's starting.
   
  2. Get Area Method
    a. gets all possible movements and mark them as visited and calculate grid
  
   
*/

import java.util.*;

public class Solution {

    private List<int[]> directions = new ArrayList<>(Arrays.asList(new int[]{0,-1}, new int[]{0,1}, new int[]{-1,0}, new int[]{1,0}));

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = 1;
                    maxArea = Math.max(maxArea, getCurrentArea(i, j, grid, visited));
                }
            }
        }
        return maxArea;
    }

    private int getCurrentArea(int i, int j, int[][] grid, boolean[][] visited) {
        int currentArea = 0;
        Queue<int[]> processQueue = new ArrayDeque<>();
        processQueue.add(new int[]{i, j});
        visited[i][j] = true;
        while(!processQueue.isEmpty()) {
            currentArea++;
            int[] oldPoint = processQueue.remove();
            for(int[] possibleDirection : directions) {
                int[] newPoint = { oldPoint[0] + possibleDirection[0], oldPoint[1] + possibleDirection[1] };
                if(newPoint[0] >= grid.length || newPoint[1] >= grid[0].length || newPoint[0] < 0 || newPoint[1] < 0) {
                    continue;
                }
                if(grid[newPoint[0]][newPoint[1]] == 0) {
                    continue;
                }
                if(visited[newPoint[0]][newPoint[1]]) {
                    continue;
                }
                processQueue.add(newPoint);
                visited[newPoint[0]][newPoint[1]] = true;
            }
        }
        return currentArea;
    }
