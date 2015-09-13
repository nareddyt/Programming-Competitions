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
 * TASK: milktemp
 */

public class milktemp
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("milktemp.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milktemp.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[][] ranges = new int[Integer.parseInt(st.nextToken())][2];
		final int cold = Integer.parseInt(st.nextToken());
		final int normal = Integer.parseInt(st.nextToken());
		final int hot = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < ranges.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			ranges[i][0] = Integer.parseInt(st.nextToken());
			ranges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Working to HERE
		int min = ranges[0][0];
		int max = ranges[0][0];
		for (int a = 0; a < ranges.length; a++)
		{
			for (int b = 0; b < 2; b++)
			{
				int temp = ranges[a][b];
				if (temp < min)
				{
					min = temp;
				}
				else if (temp > max)
				{
					max = temp;
				}
			}
		}
		// Working to HERE
		
		int maxMilk = 0; // using for max temp now
		int total = 0;
		for (int i = min; i <= max; i++) // For each temp
		{
			for (int j = 0; j < ranges.length; j++)
			{
				if (i < ranges[j][0])
				{
					total += cold;
				}
				else if (i > ranges[j][1])
				{
					total += hot;
				}
				else
				{
					total += normal;
				}
			}
			
			if (total > maxMilk)
			{
				maxMilk = total;
			}
			total = 0;
		}
		
		// END
		out.println(maxMilk);
		out.close();
		f.close();
		System.exit(0);
	}
}
