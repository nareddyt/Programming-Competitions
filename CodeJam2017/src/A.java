import java.io.*;
import java.util.*;

/*
 * Teju Nareddy
 * 4/8/17
 * CodeJam 2017: Problem A
 */
public class A {
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("A-small-attempt0.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-small-out.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int cases = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cases; i++)
        {
            st = new StringTokenizer(f.readLine());

            String pancake = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if (pancake.length() - k + 1 <= 0) {
                out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                break;
            }

            Queue<Tuple> open = new LinkedList<>();
            HashSet<String> closed = new HashSet<>();

            Tuple t = new Tuple(pancake, 0);
            open.add(t);

            while (!open.isEmpty()) {
                Tuple curr = open.remove();
                String current = curr.pancake;
                int cost = curr.cost;

                if (isSolution(current)) {
                    out.println("Case #" + (i + 1) + ": " + cost);
                    break;
                }

                List<String> successors = generateSuccessors(current, k);
                for (String successor : successors) {
                    if (!closed.contains(successor)) {
                        Tuple newT = new Tuple(successor, cost + 1);
                        open.add(newT);
                        closed.add(successor);
                    }
                }

                if (open.isEmpty()) {
                    out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    break;
                }
            }
        }

        f.close();
        out.close();
    }

    private static boolean isSolution(String pancakes) {
        for (int i = 0; i < pancakes.length(); i++) {
            if (pancakes.charAt(i) == '-') {
                return false;
            }
        }

        return true;
    }

    private static List<String> generateSuccessors(String root, int k) {
        List<String> successors = new ArrayList<>(root.length() - k + 1);

        for (int i = 0; i < root.length() - k + 1; i++) {
            StringBuilder sb = new StringBuilder(root.length());

            // Add chars to the left of spatula
            for (int j = 0; j < i; j++) {
                sb.append(root.charAt(j));
            }

            // Add the flipped chars
            for (int j = i; j < i + k; j++) {
                char curr = root.charAt(j);
                if (curr == '+') {
                    sb.append('-');
                } else {
                    sb.append('+');
                }
            }

            // Add chars to the right of the spatula
            for (int j = i + k; j < root.length(); j++) {
                sb.append(root.charAt(j));
            }

            successors.add(sb.toString());
        }

        return successors;
    }

    public static class Tuple {
        String pancake;
        int cost;

        Tuple(String p, int c) {
            pancake = p;
            cost = c;
        }

    }
}
