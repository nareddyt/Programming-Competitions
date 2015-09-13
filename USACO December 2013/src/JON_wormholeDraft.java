/*
 * ID: kevin63857
 * LANG: JAVA
 * TASK: records
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JON_wormholeDraft
{
	static int holes;
	static int loops;
	static boolean keepGoing = true;
	
	public static void main(String[] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		/*
		 * holes=2;
		 * int[][] pairings2={
		 * {0,1},};
		 * //for(int i=0;i<3;i++)fillWithHighest(pairings2,2);
		 * double[
		 * System.out.println(Arrays.toString(curSpot));
		 * System.exit(0);
		 */
		BufferedReader f = new BufferedReader(new FileReader("wormhole.txt"));
		// input file name goes above
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		holes = Integer.parseInt(st.nextToken());
		int[][] pairings = new int[holes / 2][2];
		int[][] coordinates = new int[holes][2];
		for (int i = 0; i < holes; i++)
		{
			st = new StringTokenizer(f.readLine());
			coordinates[i][0] = Integer.parseInt(st.nextToken()) + 1;
			coordinates[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < holes / 2; i++)
		{
			pairings[i][0] = 2 * i;
			pairings[i][1] = 2 * i + 1;
		}
		while (keepGoing)
		{
			check(pairings, coordinates);
			
			repair(pairings);
			/*
			 * for(int i=0;i<holes/2;i++){
			 * System.out.println(pairings[i][0]+" "+pairings[i][1]);
			 * }
			 * System.out.println();
			 */
			// if(i2==4)
			// keepGoing=false;
		}
		// st = new StringTokenizer(f.readLine());
		// st.nextToken();
		System.out.println("Time (ms): " + (System.currentTimeMillis() - startTime));
		System.out.println(loops);
		// out.close();
		f.close();
		System.exit(0);
	}
	
	private static void check(int[][] pairings, int[][] coordinates)
	{
		double[][] starts = findStarts(coordinates);
		for (int i = 0; i < holes; i++)
		{
			double[] curSpot = Arrays.copyOf(starts[i], 2);
			teleport(curSpot, coordinates, pairings);
			double[] secondSpot = Arrays.copyOf(curSpot, 2);
			while (!noneToRight(curSpot, coordinates))
			{
				// System.out.println(Arrays.toString(curSpot)+" "+Arrays.toString(secondSpot));
				curSpot = teleport(curSpot, coordinates, pairings);
				if (curSpot[0] == secondSpot[0] && curSpot[1] == secondSpot[1])
				{
					loops++;
					/*
					 * for(int i12=0;i12<holes/2;i12++){
					 * System.out.println((pairings[i12][0]+1)+" "+(pairings[i12][1]+1));
					 * }
					 * System.out.println();
					 */
					return;
				}
			}
		}
	}
	
	private static double[] teleport(double[] curSpot, int[][] coordinates, int[][] pairings)
	{
		int[] lookingFor =
		{ (int) (curSpot[0] + .5), (int) curSpot[1] };
		int closestX = 2000000000;
		int closestIndex = -1;
		for (int i = 0; i < holes; i++)
		{
			if (coordinates[i][1] == lookingFor[1] && coordinates[i][0] - lookingFor[0] >= 0
					&& coordinates[i][0] - lookingFor[0] < closestX - lookingFor[0])
			{
				closestX = coordinates[i][0];
				closestIndex = i;
			}
		}
		int other = -1;
		for (int i = 0; i < holes / 2; i++)
		{
			if (pairings[i][0] == closestIndex)
			{
				other = pairings[i][1];
			}
			else if (pairings[i][1] == closestIndex)
			{
				other = pairings[i][0];
			}
		}
		/*
		 * if(other==-1){
		 * //System.out.println(Arrays.toString(curSpot));
		 * for(int i=0;i<holes/2;i++){
		 * System.out.println(coordinates[i][0]+" "+coordinates[i][1]);
		 * }
		 * }
		 */
		curSpot[0] = coordinates[other][0] + .5;
		curSpot[1] = coordinates[other][1];
		return curSpot;
	}
	
	private static boolean noneToRight(double[] curSpot, int[][] coordinates)
	{
		for (int[] i : coordinates)
			if ((int) curSpot[1] == i[1] && curSpot[0] < i[0])
				return false;
		return true;
	}
	
	private static double[][] findStarts(int[][] coordinates)
	{
		double[][] starts = new double[holes][2];
		for (int i = 0; i < holes; i++)
		{
			starts[i][0] = coordinates[i][0] - .5;
			starts[i][1] = coordinates[i][1];
		}
		return starts;
	}
	
	private static void repair(int[][] pairings)
	{
		int rowChecking = holes / 2 - 2;
		boolean notDone = true;
		while (rowChecking >= 0 && notDone)
		{
			int[] happy = getHappy(pairings, holes / 2 - rowChecking);
			if (pairings[rowChecking][1] != happy[happy.length - 1])
			{
				notDone = false;
			}
			else
			{
				rowChecking--;
			}
		}
		if (rowChecking < 0)
		{
			keepGoing = false;
			return;
		}
		fillWithHighest(pairings, holes / 2 - rowChecking);
	}
	
	private static int[] getHappy(int[][] pairings, int levels)
	{
		int[] happy = new int[2 * levels - 1];
		int next = -1;
		int bottom = (holes / 2) - levels;
		// System.out.println(bottom);
		for (int i = bottom + 1; i < holes / 2; i++)
		{
			// System.out.println(Arrays.toString(happy));
			next++;
			happy[next++] = pairings[i][0];
			happy[next] = pairings[i][1];
		}
		happy[2 * levels - 2] = pairings[bottom][1];
		Arrays.sort(happy);
		
		return happy;
		
	}
	
	private static void fillWithHighest(int[][] pairings, int levels)
	{
		int[] happy = getHappy(pairings, levels);
		int bottom = (holes / 2) - levels;
		// System.out.println(Arrays.toString(happy));
		ArrayList<Integer> happy2 = new ArrayList<Integer>(0);
		for (int i = 0; i < happy.length; i++)
		{
			happy2.add(happy[i]);
		}
		pairings[bottom][1] = happy2.remove(find(pairings[bottom][1] + 1, happy2));
		for (int i = bottom + 1; i < holes / 2; i++)
		{
			pairings[i][0] = happy2.remove(0);
			pairings[i][1] = happy2.remove(0);
		}
	}
	
	private static int find(int i2, ArrayList<Integer> happy2)
	{
		for (int i = 0; i < happy2.size(); i++)
		{
			if (i2 == happy2.get(i))
				return i;
		}
		// System.out.println(Arrays.toString(happy2.toArray()));
		return find(++i2, happy2);
	}
	
	private static int fact(int holes)
	{
		int total = 1;
		for (int i = 1; i <= holes; i++)
		{
			total *= holes;
		}
		return total;
	}
	
}
