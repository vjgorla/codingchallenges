/**
 * Solves any sudoku puzzle. Set known values in the static array <tt>d</tt>
 * and leave unknown values as zero.
 * 
 * @author Vijay Gorla
 */

public class Sudoku {
    
    private final int[] d = new int[]{2,4,9,  5,0,0,  0,0,0,
                                      0,0,0,  0,0,0,  0,0,0,
                                      3,0,0,  1,8,7,  0,0,0,

                                      0,1,0,  0,2,0,  0,0,0,
                                      5,8,0,  0,0,0,  0,4,1,
                                      0,0,0,  0,3,0,  0,6,0,

                                      0,0,0,  0,0,0,  0,0,0,
                                      0,0,0,  0,0,2,  8,3,5,
                                      0,0,0,  6,4,9,  0,0,7};
    private final int[] p = (int[])d.clone();

    private void solve() {
        int i = 0, num = 0, dir = 0;
        while(i < 81) {
            if (p[i] > 0) {
                if (dir == 0) i++;
                else num = d[--i];
            } else if (num == 9) {
                d[i--] = 0; num = d[i]; dir = 1;
            } else if (isValid(i, ++num)) {
                d[i] = num; i++;  num = 0; dir = 0;
            }
        }
    }

    private boolean isValid(int pos, int num) {
        // Check horizontal
        for (int i = ((int)(pos/9))*9; i < (((int)(pos/9))*9)+9; i++) {
            if (i != pos && d[i] == num) { return false; }
        }
        // Check vertical
        for (int i = pos%9; i <= (pos%9)+(9*9)-9; i+=9) {
            if (i != pos && d[i] == num) { return false; }
        }
        // Check the grid
        int gp = ((int)(pos/27))*27 + (pos%9);
        int gsp = ((int)(gp/3))*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int k = gsp+(i*9)+j;
                if (k != pos && d[k] == num) { return false; }
            }
        }
        return true;
   }

   private void print() {
       for (int i = 0; i < 9; i++) {
           System.out.println();
           for (int j = 0; j < 9; j++) {
               System.out.print(d[(i*9)+j] + " ");
           }
       }
   }

   public static void main(String args[]) {
       Sudoku sudoku = new Sudoku();
       sudoku.solve();
       sudoku.print();
   }
}
