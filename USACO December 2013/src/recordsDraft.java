import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: milktemp
 */

public class recordsDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("records.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milktemp.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String[][] names = new String[n][3]; // n rows, 3 cols
		for (int a = 0; a < n; a++)
		{
			st = new StringTokenizer(f.readLine());
			for (int b = 0; b < 3; b++)
			{
				names[a][b] = st.nextToken();
			}
			Arrays.sort(names[a]);
		}
		
		// 2D comparator --> Compares all 3 cols
		Arrays.sort(names, new Comparator<String[]>()
		{
			@Override
			public int compare(String[] a, String[] b)
			{
				// Simulates an Array comparator --> Like a String.compareTo() for Arrays
				if (a[0].compareTo(b[0]) == 0)
				{
					if (a[1].compareTo(b[1]) == 0)
						return a[2].compareTo(b[2]);
					else
						return a[1].compareTo(b[1]);
				}
				else
					return a[0].compareTo(b[0]);
			}
		});
		
		int count1 = 1; // temp count
		int count2 = 0; // final count
		String[] init = names[0];
		for (int i = 1; i < n; i++)
		{
			if (Arrays.equals(init, names[i]))
			{
				count1++;
			}
			else
			{
				init = names[i];
				count1 = 1;
			}
			if (count1 > count2)
			{
				count2 = count1;
			}
		}
		
		System.out.println(count2); // SUCESS
		f.close();
		System.exit(0);
	}
}
