import java.util.Arrays;
import java.util.Comparator;

public class CircularSuffixArray {

    private int length;
    private Integer[] index;
    private char[] value;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) { throw new IllegalArgumentException("Argument cannot be null."); }
        length = s.length();
        index = new Integer[length];
        value = new char[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
            value[i] = s.charAt(i);
        }

        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                for (int i = 0; i < length; i++) {
                    char c1 = value[(i + o1) % length];
                    char c2 = value[(i + o2) % length];
                    if (c1 > c2) return 1;
                    if (c1 < c2) return -1;
                }
                return 0;
            }
        });

    }

    // length of s
    public int length() {
        return length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > length-1) { throw new IllegalArgumentException("Argument out of bounds"); }
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray("ABRACADABRA!");
        for (int i = 0; i < circularSuffixArray.length(); i++) {
            System.out.println(circularSuffixArray.index(i) + " ");
        }
    }
}
