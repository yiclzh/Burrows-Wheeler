import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {


    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        int r = 256;
        char[] chars = new char[r];
        for (int i = 0; i < r; ++i) {
            chars[i] = (char) i;
        }

        char c;
        while (!BinaryStdIn.isEmpty()) {
            c = BinaryStdIn.readChar();
            int i = 0;
            while (chars[i] != c) {
                ++i;
            }
            BinaryStdOut.write((char) i);
            while (i > 0) {
                chars[i] = chars[--i];
            }
            chars[0] = c;
        }

        BinaryStdIn.close();
        BinaryStdOut.close();
    }


    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        int r = 256;
        char[] chars = new char[r];
        for (int i = 0; i < r; ++i) {
            chars[i] = (char) i;
        }

        int i;
        while (!BinaryStdIn.isEmpty()) {
            i = BinaryStdIn.readChar();
            char c = chars[i];
            BinaryStdOut.write(c);
            while (i > 0) {
                chars[i] = chars[--i];
            }
            chars[0] = c;
        }

        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        }
        if (args[0].equals("+")) {
            decode();
        }
    }
}
