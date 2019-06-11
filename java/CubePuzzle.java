import java.util.Arrays;

/**
 * The snake cube is a mechanical puzzle, a chain of 27 cubelets, connected by an elastic band running 
 * through them. The cubelets can rotate freely. The aim of the puzzle is to arrange the chain in such a 
 * way that they will form 3 x 3 x 3 cube.
 *
 * http://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Snakecube_1.jpg/220px-Snakecube_1.jpg
 *
 * Solves any cube puzzle given their rotating node indexes.
 *
 * Answer:
 * <pr>
 * [[0,0,0], [1,0,0], [2,0,0], [2,0,1], [2,0,2], [1,0,2], 
 * [0,0,2], [0,1,2], [0,2,2], [1,2,2], [1,1,2], [2,1,2], 
 * [2,1,1], [2,1,0], [1,1,0], [0,1,0], [0,2,0], [0,2,1], 
 * [0,1,1], [0,0,1], [1,0,1], [1,1,1], [1,2,1], [1,2,0], 
 * [2,2,0], [2,2,1], [2,2,2]]
 * </pr>
 *
 * @author Vijay Gorla 
 */
public class CubePuzzle {

    private Point[] p 
        = new Point[]{new Point(false),new Point(false),new Point(true),
                      new Point(false), new Point(true),
                      new Point(false),new Point(true),
                      new Point(false), new Point(true),
                      new Point(true),
                      new Point(true),
                      new Point(true),
                      new Point(false), new Point(true),
                      new Point(false), new Point(true),
                      new Point(true),
                      new Point(true),
                      new Point(false), new Point(true),
                      new Point(true),
                      new Point(false), new Point(true),
                      new Point(true),
                      new Point(true), 
                      new Point(false), new Point(false)};
    
    private void solve() {
        long startTime = System.currentTimeMillis();
        int index = 1, count = 0;
        p[0].x = 0; p[0].y = 0; p[0].z = 0;
        p[0].axis = Axis.X; p[0].dir = Dir.PLUS;
        while (true) {
            if (index < (p.length-1) || (index == (p.length-1) && !p[index].done())) {
                if (p[index].done()) {
                    p[index].reset();
                    index--;
                    if (index == 0) break;
                } else {
                    boolean isvalid = p[index].rotate(p[index-1]);
                    //System.out.println(++count + " - " + Arrays.toString(Arrays.copyOfRange(p, 0, index+1)));
                    if (isvalid && isValid(index)) {
                        if (index < (p.length-1)) {
                            index++;
                        } else {
                            System.out.println(Arrays.toString(p));
                            break;
                        }
                    }
                }
            } else {
                p[index].reset();
                index--;
                if (index == 0) break;
            }
        }
        System.out.println("Time : " + (System.currentTimeMillis() - startTime));
    }
    
    private boolean isValid(int index) {
        for (int i = 0; i < index; i++) {
            if (p[index].x == p[i].x && p[index].y == p[i].y && p[index].z == p[i].z) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        CubePuzzle puzzle = new CubePuzzle();
        puzzle.solve();
    }
    
    private static enum Axis {
        X, Y, Z;
    }
    private static enum Dir {
        PLUS, MINUS;
    }
    
    private static class Point {
        int x, y, z;
        int pos;
        boolean rotatable;
        Axis axis;
        Dir dir;
        Point(boolean rotatable) {
            this.rotatable = rotatable;
            reset();
        }
        void reset() {
            pos = -1;
        }
        boolean done() {
            if (rotatable) {
                return pos == 3;
            } else {
                return pos == 0;
            }
        }
        boolean rotate(Point prev) {
            x = prev.x; y = prev.y; z = prev.z;
            if (prev.axis == Axis.X) {
                if (prev.dir == Dir.PLUS) x++; else x--;
            } else if (prev.axis == Axis.Y) {
                if (prev.dir == Dir.PLUS) y++; else y--;
            } else {
                if (prev.dir == Dir.PLUS) z++; else z--;
            }
            pos++;
            if (x < 0 || x > 2 || y < 0 || y > 2 || z < 0 || z > 2) {
                return false;
            }
            if (rotatable) {
                if (prev.axis == Axis.X) { //YZ plane
                    if (pos == 0) {
                        axis = Axis.Z; dir = Dir.PLUS;
                    } else if (pos == 1) {
                        axis = Axis.Y; dir = Dir.MINUS;
                    } else if (pos == 2) {
                        axis = Axis.Z; dir = Dir.MINUS;
                    } else {
                        axis = Axis.Y; dir = Dir.PLUS;
                    }
                } else if (prev.axis == Axis.Y) { // XZ plane
                    if (pos == 0) {
                        axis = Axis.Z; dir = Dir.PLUS;
                    } else if (pos == 1) {
                        axis = Axis.X; dir = Dir.MINUS;
                    } else if (pos == 2) {
                        axis = Axis.Z; dir = Dir.MINUS;
                    } else {
                        axis = Axis.X; dir = Dir.PLUS;
                    }
                } else { // XY plane
                    if (pos == 0) {
                        axis = Axis.X; dir = Dir.MINUS;
                    } else if (pos == 1) {
                        axis = Axis.Y; dir = Dir.MINUS;
                    } else if (pos == 2) {
                        axis = Axis.X; dir = Dir.PLUS;
                    } else {
                        axis = Axis.Y; dir = Dir.PLUS;
                    }
                }
            } else {
                axis = prev.axis;
                dir = prev.dir;
            }
            return true;
        }
        public String toString() {
            return "[" + x + "," + y + "," + z + "]"; 
        }
    }
}
