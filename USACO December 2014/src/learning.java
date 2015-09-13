import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: learning
 */

public class learning
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("learning.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[][] cows = new int[Integer.parseInt(st.nextToken())][2];
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < cows.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			String type = st.nextToken();
			if (type.equals("NS"))
			{
				cows[i][1] = -1;
			}
			else
			{
				cows[i][1] = 1;
			}
			cows[i][0] = Integer.parseInt(st.nextToken());
		}
		
		java.util.Arrays.sort(cows, new java.util.Comparator<int[]>()
		{
			@Override
			public int compare(int[] a, int[] b)
			{
				return Integer.compare(a[0], b[0]);
			}
		});
		
		ArrayList<Double> mids = new ArrayList<Double>();
		int i = 0;
		
		while (i < cows.length - 1)
		{
			if (cows[i][1] != cows[i + 1][1])
			{
				mids.add((cows[i + 1][0] - cows[i][0]) / 2.0 + cows[i][0]);
			}
			i++;
		}
		
		int count = 0;
		if (cows[i][1] == 1)
		{
			int j = 1;
			while (j < mids.size() && mids.get(j) < max)
			{
				count += mids.get(j).intValue() - mids.get(j - 1).intValue() + 1;
				j++;
			}
		}
		
		out.println(count);
		out.close();
		f.close();
		System.exit(0);
	}
}
