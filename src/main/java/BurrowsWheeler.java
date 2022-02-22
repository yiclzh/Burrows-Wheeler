import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        int first = 0;
        CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);
        for (int i = 0; i < s.length(); i++) {
            if (circularSuffixArray.index(i) == 0) {
                first = i;
            }
        }
        BinaryStdOut.write(first);
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = ((circularSuffixArray.index(i) - 1 + s.length()) % s.length());
            char last = s.charAt(lastIndex);
            BinaryStdOut.write(last);

        }
        BinaryStdOut.close();

    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
//        int first = BinaryStdIn.readInt();
//        String s = BinaryStdIn.readString();
        int first = 3;
        String s = "ARD!RCAAAABB";
        int R = 256;
        int n = s.length();
        int[] next = new int[n];
        int[] count = new int[R + 1];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) + 1]++;
        }
        for (int r = 1; r < R + 1; r++) {
            count[r] += count[r-1];
        }
        for (int i = 0; i < n; i++) {
            next[count[s.charAt(i)]++] = i;
        }
        for (int i = next[first], c = 0; c < n; i = next[i], c++) {
            System.out.println(s.charAt(i));
        }

    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        BurrowsWheeler.inverseTransform();
    }
}
