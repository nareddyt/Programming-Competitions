import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: marathon
 */

public class marathon
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[][] locations = new int[Integer.parseInt(st.nextToken())][2];
		
		for (int i = 0; i < locations.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			locations[i][0] = Integer.parseInt(st.nextToken());
			locations[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] distances1 = new int[locations.length - 1];
		int[] distances2 = new int[locations.length - 2];
		
		for (int i = 0; i < locations.length - 1; i++)
		{
			distances1[i] = Math.abs(Math.abs(locations[i][0] - locations[i + 1][0])
					+ Math.abs(locations[i][1] - locations[i + 1][1]));
			if (i != locations.length - 2)
			{
				distances2[i] = Math.abs(Math.abs(locations[i][0] - locations[i + 2][0])
						+ Math.abs(locations[i][1] - locations[i + 2][1]));
			}
		}
		
		int maxChange = 0;
		int index = 0;
		for (int i = 0; i < locations.length - 2; i++)
		{
			int change = distances1[i] + distances1[i + 1] - distances2[i];
			if (change > maxChange)
			{
				maxChange = change;
				index = i + 1;
			}
		}
		
		locations[index][0] = -1001;
		
		out.println(calculateDistance(locations));
		out.close();
		f.close();
		System.exit(0);
	}
	
	public static int calculateDistance(int[][] locations)
	{
		int distance = 0;
		for (int i = 0; i < locations.length - 1; i++)
		{
			int x1 = locations[i][0];
			int x2 = locations[i + 1][0];
			int y1 = locations[i][1];
			int y2 = locations[i + 1][1];
			
			if (x2 != -1001)
			{
				distance += Math.abs(x2 - x1) + Math.abs(y2 - y1);
			}
			else
			{
				i++;
				x2 = locations[i + 1][0];
				y2 = locations[i + 1][1];
				distance += Math.abs(x2 - x1) + Math.abs(y2 - y1);
			}
		}
		return distance;
	}
}
