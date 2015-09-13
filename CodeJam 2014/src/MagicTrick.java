import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Teju Nareddy

// Check if number is in both rows

public class MagicTrick
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("A-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("magicOut.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int cases = Integer.parseInt(st.nextToken());
		int row1;
		int row2;
		int[] cards1 = new int[4];
		int[] cards2 = new int[4];
		int matches;
		
		for (int i = 1; i <= cases; i++)
		{
			st = new StringTokenizer(f.readLine());
			row1 = Integer.parseInt(st.nextToken());
			if (row1 == 1)
			{
				st = new StringTokenizer(f.readLine());
				cards1[0] = Integer.parseInt(st.nextToken());
				cards1[1] = Integer.parseInt(st.nextToken());
				cards1[2] = Integer.parseInt(st.nextToken());
				cards1[3] = Integer.parseInt(st.nextToken());
				f.readLine();
				f.readLine();
				f.readLine();
			}
			if (row1 == 2)
			{
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards1[0] = Integer.parseInt(st.nextToken());
				cards1[1] = Integer.parseInt(st.nextToken());
				cards1[2] = Integer.parseInt(st.nextToken());
				cards1[3] = Integer.parseInt(st.nextToken());
				f.readLine();
				f.readLine();
			}
			if (row1 == 3)
			{
				f.readLine();
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards1[0] = Integer.parseInt(st.nextToken());
				cards1[1] = Integer.parseInt(st.nextToken());
				cards1[2] = Integer.parseInt(st.nextToken());
				cards1[3] = Integer.parseInt(st.nextToken());
				f.readLine();
			}
			if (row1 == 4)
			{
				f.readLine();
				f.readLine();
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards1[0] = Integer.parseInt(st.nextToken());
				cards1[1] = Integer.parseInt(st.nextToken());
				cards1[2] = Integer.parseInt(st.nextToken());
				cards1[3] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(f.readLine());
			row2 = Integer.parseInt(st.nextToken());
			if (row2 == 1)
			{
				st = new StringTokenizer(f.readLine());
				cards2[0] = Integer.parseInt(st.nextToken());
				cards2[1] = Integer.parseInt(st.nextToken());
				cards2[2] = Integer.parseInt(st.nextToken());
				cards2[3] = Integer.parseInt(st.nextToken());
				f.readLine();
				f.readLine();
				f.readLine();
			}
			if (row2 == 2)
			{
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards2[0] = Integer.parseInt(st.nextToken());
				cards2[1] = Integer.parseInt(st.nextToken());
				cards2[2] = Integer.parseInt(st.nextToken());
				cards2[3] = Integer.parseInt(st.nextToken());
				f.readLine();
				f.readLine();
			}
			if (row2 == 3)
			{
				f.readLine();
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards2[0] = Integer.parseInt(st.nextToken());
				cards2[1] = Integer.parseInt(st.nextToken());
				cards2[2] = Integer.parseInt(st.nextToken());
				cards2[3] = Integer.parseInt(st.nextToken());
				f.readLine();
			}
			if (row2 == 4)
			{
				f.readLine();
				f.readLine();
				f.readLine();
				st = new StringTokenizer(f.readLine());
				cards2[0] = Integer.parseInt(st.nextToken());
				cards2[1] = Integer.parseInt(st.nextToken());
				cards2[2] = Integer.parseInt(st.nextToken());
				cards2[3] = Integer.parseInt(st.nextToken());
			}
			
			matches = numOfMatches(cards1, cards2);
			if (matches == 1)
			{
				System.out.println("Case #" + i + ": " + getMatch(cards1, cards2));
				out.println("Case #" + i + ": " + getMatch(cards1, cards2));
			}
			else if (matches > 1)
			{
				System.out.println("Case #" + i + ": Bad magician!");
				out.println("Case #" + i + ": Bad magician!");
			}
			else
			{
				System.out.println("Case #" + i + ": Volunteer cheated!");
				out.println("Case #" + i + ": Volunteer cheated!");
			}
		}
		out.close();
	}
	
	public static int numOfMatches(int[] a, int[] b)
	{
		int count = 0;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (a[i] == b[j])
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int getMatch(int[] a, int[] b)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (a[i] == b[j])
					return a[i];
			}
		}
		return -1;
	}
}
