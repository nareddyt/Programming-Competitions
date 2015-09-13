import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: baseball
 */

public class baseballDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("baseball.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] positions = new int[n];
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			positions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(positions);
		
		int count = 0;
		for (int a = 0; a < n; a++)
		{
			for (int b = a + 1; b < n; b++)
			{
				for (int c = b + 1; c < n; c++)
				{
					int bc = positions[c] - positions[b];
					int ab = positions[b] - positions[a];
					if (bc >= ab && bc <= 2 * ab)
					{
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
		f.close();
		System.exit(0);
	}
}
