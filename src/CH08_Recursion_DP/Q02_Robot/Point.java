package CH08_Recursion_DP.Q02_Robot;

public class Point {
    public int row, col;
    public Point(int r, int c) {
        this.row = r;
        this.col = c;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).col == this.col)) {
            return true;
        } else {
            return false;
        }
    }
}