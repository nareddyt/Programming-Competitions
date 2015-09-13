import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: cowjog
 */

public class cowjogDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowjogIn.txt")); // FIXME
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int[][] cows = new int[Integer.parseInt(st.nextToken())][2];
		
		for (int i = 0; i < cows.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < 2; j++)
			{
				cows[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int groups = 1;
		int index = cows.length - 1;
		int newIndex = index;
		while (newIndex > 0)
		{
			newIndex--;
			if (cows[newIndex][1] <= cows[index][1])
			{
				if (cows[index][0] - cows[newIndex][0] > index - newIndex)
				{
					groups++;
					index = newIndex;
				}
			}
		}
		
		System.out.println(groups);
		// out.close();
		f.close();
		System.exit(0);
	}
}
