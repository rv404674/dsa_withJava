package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bufferedReaderBasics {

    // TODO: In interviews use scanner, as it is easy to use.
    // NOTE: Scanner vs Buffered Reader
    // Diffs
    // Buffered Reader is synchronized (thread-safe) while scanner is not.
    // BR has a bigger, changeable buffer size while scanner has a fixed buffer size.

    // NOTE: CRUX
    // https://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader
    // Use scanner when you want to parse and use BR when to just want to read (dumb reading).
    // parse - interpreting the input as tokens (int, decimal, string). see scanner has nextInt() classes.

    // ALSO NOTE:
    // BR - minized the number of IO calls. As it will read a buffer of bytes (1024) from the file instead
    // of reading one by one from the file.
    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }

    public static void main(String[] args) throws IOException {
        // read from users
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        String strLine = "";

        while ((line = br.readLine()) != null)
            System.out.println(br.readLine());
    }



}
