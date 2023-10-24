package com.nosh.PicoTrainer.MazeSystem;

import java.util.*;
 
public class MazeSolver {
    
    public static List<int[]> findPathInIntMaze(int[][] maze, int startX, int startY, int targetX, int targetY){
        boolean[][] mazeb = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(maze[i][j] == 0){
                    mazeb[i][j] = true;
                }
            }
        }
        return findPathInMaze(mazeb, startX, startY, targetX, targetY);
    }
    
    
    public static List<int[]> findPathInMaze(boolean[][] maze, int startX, int startY, int targetX, int targetY) {
        int[] dx = {0, 0, 1, -1}; // Arrays to represent the 4 directions
        int[] dy = {1, -1, 0, 0};

        int m = maze.length; // number of rows in the maze
        int n = maze[0].length; // number of columns in the maze

        boolean[][] visited = new boolean[m][n]; // create a boolean array to mark visited cells
        Map<int[], int[]> parent = new HashMap<>(); // create a map to hold the parent coordinates for each visited coordinate

        Queue<int[]> queue = new LinkedList<>(); // create a queue to hold the coordinates of the cells to be explored

        queue.offer(new int[]{startX, startY}); // add the starting position to the queue

        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); // remove the next coordinate from the queue
            int x = curr[0];
            int y = curr[1];

            if (x == targetX && y == targetY) { // if the coordinate is the target position, reconstruct and return the path to it
                List<int[]> path = new ArrayList<>();
                int[] node = curr;

                while (node != null) {
                    path.add(node);
                    node = parent.get(node);
                }

                Collections.reverse(path);
                return path;
            }

            if (!visited[x][y]) { // if the coordinate has not been visited
                visited[x][y] = true; // mark the coordinate as visited

                for (int i = 0; i < 4; i++) { // check the adjacent cells
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] && !visited[nx][ny]) { // if an adjacent cell is valid and not blocked, add it to the queue and set its parent coordinate in the map
                        int[] neighbor = new int[]{nx, ny};
                        queue.offer(neighbor);
                        parent.put(neighbor, curr);
                    }
                }
            }
        }

        return null; // if the target position is not found, return null
    }
}
