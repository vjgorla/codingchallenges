/**
 * Solves tent puzzle.
 * 
 * @author Vijay Gorla 
 */
public class TentPuzzle {
    
    private final int[] d = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private final int[] hor = new int[]{2,3,1,2,2,2,3,1,1,3}; //{3,2,2,1,3,1,3,0,5,0};
    private final int[] ver = new int[]{3,1,2,1,1,3,1,3,0,5}; // {3,1,3,0,3,2,2,2,0,4};
    private final int[] tree = new int[]{10,15,16,23,29,30,37,41,49,51,54,66,69,71,72,77,78,85,89,96}; //{6,8,10,13,16,21,26,31,45,47,48,54,56,61,68,74,79,83,88,90}; 

    private void solve() {
        long startTime = System.currentTimeMillis();
        int item = 0, pos = 0, sc = 0;
        while(item < 20) {
            if (pos == 100) {
                d[item] = 0;
                item--; 
                //System.out.println(item + ":" + Arrays.toString(d));
                if (item == -1) break; 
                pos = d[item]+1;
            } else {
                if (isValid(item, pos)) {
                    d[item] = pos; 
                    if (item == 19) {
                        System.out.println((++sc) + " - " + java.util.Arrays.toString(d));
                        pos++;
                    } else {
                        item++;  pos = 0;
                    }
                } else {
                    pos++;
                }
            }
        }
        System.out.println("Total time : " + (System.currentTimeMillis() - startTime));
    }

    private boolean isValid(int item, int pos) {
        if (((pos/10 == tree[item]/10 && Math.abs(pos-tree[item]) == 1)
                || (Math.abs((pos/10) - (tree[item]/10)) == 1 && pos%10 == tree[item]%10))) {
        } else {
            return false;
        }
        for (int i = 0; i < 20; i++) {
            if (pos == tree[i]) {
                return false;
            }
        }
        int horc = 1, verc = 1;
        for (int i = 0; i < item; i++) {
            if (pos == d[i] 
                    || (pos/10 == d[i]/10 && Math.abs(pos-d[i]) == 1) // hor 
                    || (Math.abs((pos/10) - (d[i]/10)) == 1 && pos%10 == d[i]%10) // ver
                    || (Math.abs((pos/10) - (d[i]/10)) == 1 && Math.abs(pos%10 - d[i]%10) == 1)) {
                return false;
            }
            if (pos/10 == d[i]/10) {
                horc++;
            }
            if (pos%10 == d[i]%10) {
                verc++;
            }
        }
        if (horc > hor[pos/10] || verc > ver[pos%10]) {
            return false;
        }
        return true;
   }

   public static void main(String args[]) {
       TentPuzzle puzzle = new TentPuzzle();
       puzzle.solve();
   }
}
