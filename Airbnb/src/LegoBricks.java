import java.util.*;

public class LegoBricks {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int sumOfLevels = 1;
            List<String> possibilitiesForLevel = findWays(m);
            for (int j = 0; j < n; j++) {
                sumOfLevels *= possibilitiesForLevel.size();
            }

            int totalRemovals = 0;
            for (String combo : possibilitiesForLevel) {
                if (combo.length() == 1) {
                    continue;
                }

                int possibilityRemovals = 1;
                for (int k = 0; k < combo.length(); k++) {
                    int brick = Integer.parseInt(combo.charAt(k) + "");
                    possibilityRemovals *= Math.pow(findWays(brick).size(), n) - (brick - 1);
                }

                totalRemovals += possibilityRemovals;
            }

            System.out.println(sumOfLevels - totalRemovals);
        }
    }

    private static Map<Integer, List<String>> cache = new HashMap<>();

    private static List<String> findWays(int m) {
        if (cache.containsKey(m)) {
            return cache.get(m);
        }

        List<String> combos = new ArrayList<>();

        if (m == 1) {
            combos.add("1");
            cache.put(m, combos);
            return combos;
        } else if (m == 2) {
            combos.add("11");
            combos.add("2");
            cache.put(m, combos);
            return combos;
        } else if (m == 3) {
            combos.add("111");
            combos.add("12");
            combos.add("21");
            combos.add("3");
            cache.put(m, combos);
            return combos;
        } else if (m == 4) {
            combos.add("1111");
            combos.add("112");
            combos.add("211");
            combos.add("121");
            combos.add("22");
            combos.add("31");
            combos.add("13");
            combos.add("4");
            cache.put(m, combos);
            return combos;
        } else if (m <= 0) {
            cache.put(m, combos);
            return combos;
        }

        combos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            List<String> newCombos = findWays(m - i);
            for (String combo : newCombos) {
                combo += i;
                combos.add(combo);
            }
        }

        cache.put(m, combos);
        return combos;
    }
}
