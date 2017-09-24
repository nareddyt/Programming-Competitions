import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Solution to RoboTreasureHunt problem by Nuro.ai
 *
 * @author Tejasvi Nareddy
 * @version 07/16/17
 */
public class RoboTreasureHunt {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("inputs_sample.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input_sample.out")));

        int problems = Integer.parseInt(f.readLine());

        StringTokenizer st;
        for (int problem = 0; problem < problems; problem++) {
            st = new StringTokenizer(f.readLine());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int goldCount = Integer.parseInt(st.nextToken());

            int[] colsVal = new int[width];
            for (int i = 0; i < colsVal.length; i++) {
                colsVal[i] = 1;
            }
            int[] rowsVal = new int[height];
            for (int i = 0; i < rowsVal.length; i++) {
                rowsVal[i] = 1;
            }

            int[][] grid = new int[height][width];
            for (int h = 0; h < height; h++) {
                st = new StringTokenizer(f.readLine());

                for (int w = 0; w < width; w++) {
                    int val = Integer.parseInt(st.nextToken());

                    colsVal[w] *= (val);
                    rowsVal[h] *= (val);

                    grid[h][w] = val;
                }
            }

            PriorityQueue<Point2D> priorityQueue = new PriorityQueue<>(new Comparator<Point2D>() {
                @Override
                public int compare(Point2D o1, Point2D o2) {
                    if (o1.getY() == o2.getY()) {
                        return new Double(o1.getX()).compareTo(o2.getX());
                    } else {
                        return new Double(o1.getY()).compareTo(o2.getY());
                    }
                }
            });

            int max = -1;
            int maxX = -1;
            int maxY = -1;
            for (int count = goldCount; count > 0; count--) {

                if (count != goldCount) {
                    int val = grid[maxY][maxX];

                    for (int i = 0; i < rowsVal.length; i++) {
                        rowsVal[i] = rowsVal[i] / val * (val - 1);
                    }

                    for (int i = 0; i < colsVal.length; i++) {
                        colsVal[i] = colsVal[i] / val * (val - 1);
                    }
                }


                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        int product = colsVal[x] * rowsVal[y];

                        if (product > max) {
                            max = product;
                            maxX = x;
                            maxY = y;
                        }
                    }
                }

                priorityQueue.add(new Point(maxX, height - maxY - 1));
            }

            while (priorityQueue.size() > 0) {
                Point2D point = priorityQueue.poll();
                System.out.println(point.getX() + " " + point.getY());
            }
        }

        out.close();
    }
}
