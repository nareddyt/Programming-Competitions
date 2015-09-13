import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fairphotoDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("fairphoto.txt")); // FIXME
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		String[] cows = new String[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < cows.length; i++)
		{
			cows[i] = f.readLine();
		}
		Arrays.sort(cows);
		
		int G = getMax(cows, "G");
		int H = getMax(cows, "H");
		if (G > 0)
		{
			System.out.println(G);
		}
		else
		{
			System.out.println(H);
		}
		f.close();
		System.exit(0);
	}
	
	public static int getMax(String[] cows, String letter)
	{
		int count = 0;
		int max = 0;
		for (int i = 0; i < cows.length; i++)
		{
			if (cows[i].contains(letter))
			{
				count++;
			}
			else
			{
				if (count > max)
				{
					max = count;
				}
				count = 0;
			}
		}
		if (count > max)
		{
			max = count;
		}
		return max;
	}
}
