package CH08_Recursion_DP.Q02_Robot;


import java.util.ArrayList;

public class Grid {

    private static boolean getPathHelper(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        /* return if out of bounds or not a valid cell */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean atOrigin = (row == 0) && (col == 0);

        /* If there's a path from start to here, add current location */
        if (atOrigin || getPathHelper(maze, row, col-1, path) ||
                getPathHelper(maze, row-1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    private static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        if (getPathHelper(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }


    public static void main(String[] args) {
        boolean[][] testMazeOne = {
                {true, true, true, false},
                {true, true, true, true},
                {false, false, false, true},
                {true, true, true, true}
        };

        // get path from the last cell in the maze
        System.out.println("Finding path of the following grid (1): ");
        ArrayList<Point> path = getPath(testMazeOne);
        System.out.println(path);
    }

}

