/**
 * Solves eight-queens-puzzle and prints all 92 possible arrangements. 
 * @author Vijay Gorla
 */

public class EightQueensPuzzle {
    
    private final int[] d = new int[]{0,0,0,0,0,0,0,0};

    private void solve() {
        int row = 0, pos = 0, sc = 0;
        while(row < 8) {
            if (pos == 8) {
                row--; 
                if (row == -1) break; 
                pos = d[row]+1;
            } else {
                if (isValid(row, pos)) {
                    d[row] = pos; 
                    if (row == 7) {
                        System.out.println((++sc) + " - " + java.util.Arrays.toString(d));
                        pos++;
                    } else {
                        row++;  pos = 0;
                    }
                } else {
                    pos++;
                }
            }
        }
    }

    private boolean isValid(int row, int pos) {
        for (int i = 0; i < row; i++) {
            if (pos == d[i] || Math.abs(pos-d[i]) == Math.abs(row-i)) {
                return false;
            }
        }
        return true;
   }

   public static void main(String args[]) {
       EightQueensPuzzle puzzle = new EightQueensPuzzle();
       puzzle.solve();
   }
}
