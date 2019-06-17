import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Solves farmer puzzle and similar problems in the series.
 * 
 * @author Vijay Gorla
 */
 
public class FarmerPuzzle {
    
    private static final int WEIGHT = 40;
    private static final int PIECES = 4;

    private void solve() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start");
        int[] weights = new int[PIECES];
        int index = 0;
        int counter = 0;
        HashSet<String> sets = new HashSet<String>();
        while (true) {
            if (weights[index] < (WEIGHT - sum(null, weights, index) - (PIECES-(index+1)))) {
                weights[index]++;
                if (index < (PIECES-2)) {
                    index++;
                } else {
                    weights[PIECES-1] = WEIGHT - sum(null, weights, index+1);
                    if (isNew(sets, null, weights, weights.length)) {
                        counter++;
                        WeightCombinations combs = new WeightCombinations();
                        comb(weights, new int[]{}, 0, combs);
                        if (combs.hasAll()) {
                            System.out.println(Arrays.toString(weights));
                            System.out.println(combs);
                            System.out.println(WEIGHT + " : " + Arrays.toString(weights));
                            break;
                        }
                    }
                }
            } else {
                weights[index] = 0;
                weights[PIECES-1] = 0;
                index--;
                if (index == -1) {
                    break;
                }
            }
        }
        System.out.println("Tried " + counter + " combinations in " 
                + (System.currentTimeMillis() - startTime) + " milli seconds");
    }
    
    private void comb(int[] values, int[] recPointers, int recursionLevel, WeightCombinations combs) {
        HashSet<String> sets = new HashSet<String>();
        for (int numItems = 1; numItems <= values.length; numItems++) {
            int[] pointers = new int[numItems];
            for (int i = 0; i < numItems; i++) {
                pointers[i] = -1;
            }
            int index = 0;
            while (true) {
                if (pointers[index] < (values.length-1)) {
                    pointers[index]++;
                    boolean used = false;
                    for (int i = 0; i < index; i++) {
                        if (pointers[index] == pointers[i]) {
                            used = true;
                            break;
                        }
                    }
                    for (int i = 0; i < recPointers.length; i++) {
                        if (pointers[index] == recPointers[i]) {
                            used = true;
                            break;
                        }
                    }
                    if (used) {
                        continue;
                    }
                    if (index < (numItems-1)) {
                        index++;
                    } else {
                        if (isNew(sets, values, pointers, numItems)) {
                            if (recursionLevel == 0) {
                                comb(values, pointers, 1, combs);
                            } else {
                                int sum1 = sum(values, recPointers, recPointers.length);
                                int sum2 = sum(values, pointers, numItems);
                                String str1 = null;
                                if (!combs.containsKey(sum1)) {
                                    str1 = toString(values, recPointers, recPointers.length);
                                    combs.put(sum1, "[" + str1 + "]");
                                }
                                if (!combs.containsKey((sum2 - sum1))) {
                                    String str2 = toString(values, pointers, numItems);
                                    if (str1 == null) str1 = toString(values, recPointers, recPointers.length);
                                    combs.put((sum2 - sum1), "[" + str2 + "] - [" + str1 + "]");
                                }
                            }
                        }
                    }
                } else {
                    pointers[index] = -1;
                    index--;
                    if (index == -1) {
                        break;
                    }
                }
            }
        }
    }
    
    private boolean isNew(HashSet<String> sets, int[] values, int[] array, int length) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < length; i++) {
            set.add(values != null ? values[array[i]] : array[i]);
        }
        String setStr = set.toString();
        if (!sets.contains(setStr)) {
            sets.add(setStr);
            return true;
        }
        return false;
    }
    
    private int sum(int[] values, int[] array, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + (values != null ? values[array[i]] : array[i]);
        }
        return sum;
    }
    
    private String toString(int[] values, int[] array, int length) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sb.length() > 0) sb.append(",");
            sb.append(values[array[i]]);
        }
        return sb.toString();
    }

    @SuppressWarnings("serial")
    private class WeightCombinations extends TreeMap<Integer, String> {
        
        private boolean hasAll() {
            return size() == (WEIGHT-1);
        }
        
        private boolean isValidWeight(int weight) {
            return (weight >= 1&& weight < WEIGHT);
        }
        
        @Override
        public boolean containsKey(Object key) {
            if (!isValidWeight((Integer)key)) {
                return true;
            } else {
                return super.containsKey(key);
            }
        }
        
        @Override
        public String put(Integer key, String value) {
            if (isValidWeight(key)) {
                return super.put(key, value);
            }
            return value;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            for (Integer weight : keySet()) {
                if (sb.length() > 0) sb.append("\n");
                sb.append(weight + " : " + get(weight));
            }
            return sb.toString();
        }
    }

    public static void main(String args[]) {
        FarmerPuzzle puzzle = new FarmerPuzzle();
        puzzle.solve();
    }
}
