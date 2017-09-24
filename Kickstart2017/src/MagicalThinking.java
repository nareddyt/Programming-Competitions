import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MagicalThinking {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("C-small-test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-out.out")));

        int cases = Integer.parseInt(f.readLine());
//        System.out.println(cases + " cases");

        for (int i = 0; i < cases; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            st.nextToken();
            int questions = Integer.parseInt(st.nextToken());

            String friend = f.readLine();
            String mine = f.readLine();
            int correct = Integer.parseInt(f.readLine());

            List<String> possibilities = new ArrayList<>();

            for(int k = 0; k < Math.pow(2,questions); k++)
            {
                String format="%0"+questions+"d";
                String poss = String.format(format,Integer.valueOf(Integer.toBinaryString(k)));
                possibilities.add(poss);
            }

            String modifiedFriend = "";
            for (int j = 0; j < friend.length(); j++) {
                if (friend.charAt(j) == 'T') {
                    modifiedFriend += "1";
                } else {
                    modifiedFriend += "0";
                }
            }

            String modMine = "";
            for (int j = 0; j < mine.length(); j++) {
                if (mine.charAt(j) == 'T') {
                    modMine += "1";
                } else {
                    modMine += "0";
                }
            }

            List<String> successors = getSuccessors(possibilities, modifiedFriend, questions - correct);
//            System.out.println(successors);

            int maxCorr = 0;
            String theOne = "";

            for (String succ : successors) {
                int corr = 0;
                for (int j = 0; j < modMine.length(); j++) {
                    char succC = succ.charAt(j);
                    char myC = modMine.charAt(j);

                    if (succC == myC) {
                        corr++;
                    }
                }

                if (corr > maxCorr) {
                    maxCorr = corr;
                    theOne = succ;
                }
            }

            out.println("Case #" + (i + 1) + ": " + maxCorr);
        }

        out.close();
    }

    private static List<String> getSuccessors(List<String> possiblities, String in, int changes) {
        List<String> successors = new ArrayList<>();

        for (String poss : possiblities) {
            if (isPossible(poss, in, changes)) {
                successors.add(poss);
            }
        }

        return successors;
    }

    private static boolean isPossible(String poss, String in, int changes) {
        int count = 0;
        for (int i = 0; i < poss.length(); i++) {
            char possC = poss.charAt(i);
            char inC = in.charAt(i);

            if (inC != possC) {
                count++;
            }
        }

        return changes == count;
    }
}
