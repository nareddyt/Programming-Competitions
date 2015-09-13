import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: nocow
 */

public class nocowDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("nocow.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int cows = Integer.parseInt(st.nextToken());
		int want = Integer.parseInt(st.nextToken());
		int adjs = 0; // FIXME
		
		st = new StringTokenizer(f.readLine());
		for (int x = 0; x < 4; x++)
		{
			st.nextToken();
		}
		while (!st.nextToken().equals("cow."))
		{
			adjs++;
		}
		
		f = new BufferedReader(new FileReader("nocow.txt"));
		st = new StringTokenizer(f.readLine());
		String[][] words = new String[cows][adjs];
		for (int a = 0; a < words.length; a++)
		{
			st = new StringTokenizer(f.readLine());
			for (int x = 0; x < 4; x++)
			{
				st.nextToken();
			}
			for (int b = 0; b < words[0].length; b++)
			{
				words[a][b] = st.nextToken();
			}
		}
		
		// WORKING TO HERE
		
		// END
		System.out.println();
		System.exit(0);
	}
}
