import java.io.*;

public class Cipher {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("A-small-test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-small-out.out")));

        int cases = Integer.parseInt(f.readLine());

        for (int i = 1; i <= cases; i++) {
            String cipher = f.readLine();
            int[] numbers = new int[cipher.length()];

            for (int j = 0; j < numbers.length; j++) {
                char c = cipher.charAt(j);
                numbers[j] = (int)c - 65;
            }

            String solution = "";
            for (int j = 0; j < 26; j++) {
                int[] possible = new int[numbers.length];
                possible[1] = numbers[0];
                possible[0] = j;
                for (int k = 2; k <= possible.length - 1; k++) {
                    possible[k] = numbers[k - 1] - possible[k - 2];
                    if (possible[k] < 0) {
                        possible[k] += 26;
                    }
                }
                if (possible[numbers.length - 2] == numbers[numbers.length - 1]) {
                    if (solution.equals("")) {
                        for (int k = 0; k < numbers.length; k++) {
                            solution += (char)(possible[k] + 65);
                        }
                    } else {
                        solution = "####";
                    }
                }
            }

            if (solution.equals("####")) {
                out.println("Case #" + i + ": AMBIGUOUS");
            } else {
                out.println("Case #" + i + ": " + solution);
            }

        }

        out.close();
    }
}
