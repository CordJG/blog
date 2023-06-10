package codingTest.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindMazeVer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        int[][] maze = new int[N][M];

        for(int i=0; i<N; i++){
            String[] str = sc.nextLine().split("");
            for(int j=0; j<M; j++){
                maze[i][j] = Integer.parseInt(str[j]);
            }
        }

        sc.close();

        int minimalTime = findMinimalTime(maze);

        System.out.println(minimalTime);

    }

    static int findMinimalTime(int[][] maze){
        int N = maze.length;              //N 은 행렬의 세로를 의미
        int M = maze[0].length;           //M 은 행렬의 가로를 의미


        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[N][M];

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        queue.add(new int[]{0, 0, 1});
        check[0][0]=true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int col = cur[0];
            int row = cur[1];
            int time = cur[2];

            if(col== N-1 && row == M-1){
                return time;
            }



            for(int[] dir : directions){
                int newCol = col+dir[0];
                int newRow = row+dir[1];

                if(newRow>=0 && newRow<M && newCol>=0 && newCol<N && maze[newCol][newRow]==1 && check[newCol][newRow]==false){
                    queue.add(new int[]{newCol, newRow, time + 1});
                }
            }
        }

        throw new IllegalArgumentException("길을 찾을 수 없습니다");
    }
}
