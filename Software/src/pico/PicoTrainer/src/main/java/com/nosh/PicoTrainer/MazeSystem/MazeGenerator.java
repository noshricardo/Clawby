package com.nosh.PicoTrainer.MazeSystem;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.nosh.PicoTrainer.MazeSystem.MazeStorage;

public class MazeGenerator {

    private static int[][] maze1 = {{1,1},{1,1}};


    public static MazeStorage genDefaultMazes() {
        MazeStorage mazeStorage = new MazeStorage();
        mazeStorage.addMaze(maze1);
        return mazeStorage;
    }

    public static MazeStorage genRandomMaze(MazeStorage mazeStorage, int sizex, int sizey) {
        Random random = new Random();
        //int[][] maze = maze1;
        int[][] maze = new int[sizex][sizey];
        //int[] row = new int[1000];
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 1;
            }
        }
        //Arrays.fill(row, 1);
        //Arrays.fill(maze, row);
        //Arrays.stream(maze).forEach(a -> Arrays.fill(a, 1));
        ArrayList<int[]> wallList = new ArrayList<>();
        int mazeNum = mazeStorage.size();

        int playerx = (int)(Math.random()*maze.length);
        int playery = (int)(Math.random()*maze[0].length);
        maze[playerx][playery] = 0;
        for(int i = -1; i <2; i += 2) {
            wallList.add(new int[]{playerx + i, playery});
            wallList.add(new int[]{playerx, playery + i});
        }
        int connections = 0;
        int runs = 0;
        int clean = 0;
        while(wallList.size() != 0) {
            connections = 0;
            //int resutl = random.nextInt(1,3);
            //int wall = (int)(Math.random() * wallList.size());
            
            int wall = (int)(random.nextInt(wallList.size()));
            System.out.println("wall: " + wall + " " + wallList.get(wall)[0] + ", " + wallList.get(wall)[1]);
            System.out.println(wallList.size() + " walls");
            for(int i = -1; i < 2; i+=2) {
                if(wallList.get(wall)[0] != maze.length-1) {
                    if((!(wallList.get(wall)[0] == 0 )&& !(wallList.get(wall)[1] == 0))&&maze[wallList.get(wall)[0] + i][wallList.get(wall)[1]]==0) {
                        connections++;
                    }
                }
                if(wallList.get(wall)[1] != maze[0].length-1) {
                    if((!(wallList.get(wall)[0] == 0 )&& !(wallList.get(wall)[1] == 0))&&maze[wallList.get(wall)[0]][wallList.get(wall)[1] + i]==0) {
                        connections++;
                    }
                }
            }
            if(connections < 2) {
                for (int i = -1; i < 2; i += 2) {
                    if ((wallList.get(wall)[0] != 0) && wallList.get(wall)[0] != maze.length - 1) {
                        if (!wallList.contains(new int[]{wallList.get(wall)[0] + i, wallList.get(wall)[1]}) && maze[wallList.get(wall)[0] + i][wallList.get(wall)[1]] != 0) {
                            wallList.add(new int[]{wallList.get(wall)[0] + i, wallList.get(wall)[1]});
                        }
                    }
                    if ((wallList.get(wall)[1] != 0) && wallList.get(wall)[1] != maze[0].length - 1) {
                        if (!wallList.contains(new int[]{wallList.get(wall)[0], wallList.get(wall)[1] + i}) && maze[wallList.get(wall)[0]][wallList.get(wall)[1] + i] != 0) {
                            wallList.add(new int[]{wallList.get(wall)[0], wallList.get(wall)[1] + i});
                        }
                    }
                }
                maze[wallList.get(wall)[0]][wallList.get(wall)[1]] = 0;
                wallList.remove(wall);
            }
            clean ++;
            if(clean >= 40) {
                wallList = cleanWalls(wallList, maze);
                clean = 0;
                System.out.println("cleaned");
            }
            runs ++;
        }
        for(int i = 0; i < 100; i++) {
            //maze[0][i] = 1;
            //maze[99][i] = 1;
            //maze[i][0] = 1;
            //maze[i][99] = 1;
        }
        mazeStorage.addMaze( maze);

        return mazeStorage;
    }

    private static ArrayList<int[]> cleanWalls(ArrayList<int[]> wallList, int[][] maze) {
        int count  = 0;
        ArrayList<Integer> remove = new ArrayList<>();
        for(int i = 0; i < wallList.size(); i++) {
            count = 0;
            if(wallList.get(i)[0] != maze.length-1) {
                if(maze[wallList.get(i)[0] + 1][wallList.get(i)[1]] == 0) {
                    count ++;
                }
            }
            if(wallList.get(i)[0] != 0) {
                if(maze[wallList.get(i)[0] - 1][wallList.get(i)[1]] == 0) {
                    count ++;
                }
            }
            if(wallList.get(i)[1] != maze[0].length-1) {
                if(maze[wallList.get(i)[0]][wallList.get(i)[1] + 1] == 0) {
                    count ++;
                }
            }
            if(wallList.get(i)[1] != 0) {
                if(maze[wallList.get(i)[0]][wallList.get(i)[1] - 1] == 0) {
                    count ++;
                }
            }
            if(count > 1) {
                remove.add(i);
            }

        }
        if(remove.size() > 0) {
            for(int i = remove.size() - 1; i > -1; i --) {
                wallList.remove(remove.get(i).intValue());
            }
        }
        System.out.println("removed " + remove.size() + " walls");
        return wallList;
    }

}
