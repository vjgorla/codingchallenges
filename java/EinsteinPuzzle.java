/**
 * Solves the classic Einstein's puzzle.
 * 
 * @author Vijay Gorla
 *
 */

public class EinsteinPuzzle {

   private static String[][] STR = new String[][] {
               { "British", "Swedish", "Danish", "Norwegian", "German" },
               { "Red", "Green", "Blue", "Yellow", "White" },
               { "Tea", "Milk", "Water", "Coffee", "Beer" },
               { "Pall Mall", "Blue Master", "Blend", "Prince", "Dunhill" },
               { "Dog", "Cat", "Horse", "Fish", "Bird" }};

   private int[][] num = new int[][] {
               {-1, -1, -1, -1, -1}, 
               {-1, -1, -1, -1, -1}, 
               {-1, -1, -1, -1, -1}, 
               {-1, -1, -1, -1, -1},
               {-1, -1, -1, -1, -1}};
   
   private void perm(int tpos) {
      int pos = 0;
      while (true) {
         num[tpos][pos]++;
         if (num[tpos][pos] > 4) {
            num[tpos][pos] = -1;
            pos--;
            if (pos == -1) break;
         } else {
            boolean used = false;
            for (int i = 0; i < pos; i++) {
               if (num[tpos][pos] == num[tpos][i]) {
                  used = true; 
                  break;
               }
            }
            if (!used) {
               if (pos < 4) {
                  pos++;
               } else {
                  if (eval(tpos)) {
                     if (tpos+1 > 4) {
                        dump();
                     } else {
                        perm(tpos+1);
                     }
                  }
               }
            }
         }
      }
   }
   
   private boolean eval(int tpos) {
      switch (tpos) {
         case 0 :
            //The Norwegian occupies the 1st house.
            if (num[0][0] != 3) return false; 
            break;
         case 1 :
            //The British occupies the red house.
            if (pos(num[0],0) != pos(num[1],0)) return false;
            //The Norwegian lives next door to the blue house.
            if (pos(num[1],2) - pos(num[0],3) != 1) return false; 
            //The green house is on the (immediate) left of the white house.
            if (pos(num[1],4) - pos(num[1],1) != 1) return false; 
            break;
         case 2 :
            //The owner of the green house drinks coffee.
            if (pos(num[1],1) != pos(num[2],3)) return false;
            //The owner of the middle house drinks milk.
            if (num[2][2] != 1) return false; 
            //The Danish drinks tea.
            if (pos(num[0],2) != pos(num[2],0)) return false; 
            break;
         case 3 :
            //The German smokes "Prince".
            if (pos(num[0],4) != pos(num[3],3)) return false; 
            //The owner of the yellow house smokes "Dunhill".
            if (pos(num[1],3) != pos(num[3],4)) return false; 
            //The person who smokes "Blue Master" drinks beer.
            if (pos(num[2],4) != pos(num[3],1)) return false; 
            //The person who smokes "Blend" lives next door to the person who drinks water.
            if (pos(num[2],2) - pos(num[3],2) != 1 && 
                        pos(num[2],2) - pos(num[3],2) != -1) return false; 
            break;
         case 4 :
            //The Swedish owns a dog.
            if (pos(num[0],1) != pos(num[4],0)) return false; 
            // The person who smokes "Pall Mall" owns a bird.
            if (pos(num[3],0) != pos(num[4],4)) return false; 
            //The person who smokes "Blend" lives next door to the person who owns a cat.
            if (pos(num[3],2) - pos(num[4],1) != 1 && 
                        pos(num[3],2) - pos(num[4],1) != -1) return false; 
            //The person who owns a horse lives next door to the person who smokes "Dunhill".
            if (pos(num[3],4) - pos(num[4],2) != 1 && 
                        pos(num[3],4) - pos(num[4],2) != -1) return false; 
            break;
      }
      return true;
   }
   
   private int pos(int[] arr, int num) {
      for (int i = 0; i < 5; i++) {
         if (arr[i] == num) {
            return i;
         }
      }
      return -1;
   }
   
   private void dump() {
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            System.out.print(String.format("%1$-15s", STR[j][num[j][i]]));
         }
         System.out.println();
      }
      System.out.println("-----------------------------------------------------------------");
   }
   
   public static void main(String args[]) {
      EinsteinPuzzle puzzle = new EinsteinPuzzle();
      puzzle.perm(0);
   }
}
