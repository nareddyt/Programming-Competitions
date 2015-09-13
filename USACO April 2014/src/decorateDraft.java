import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class decorateDraft
{
	public static char[] pastureSigns;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("decorate.txt")); // FIXME
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int pastures = Integer.parseInt(st.nextToken());
		int[][] paths = new int[Integer.parseInt(st.nextToken())][2];
		for (int i = 0; i < paths.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			paths[i][0] = Integer.parseInt(st.nextToken());
			paths[i][1] = Integer.parseInt(st.nextToken());
		}
		pastureSigns = new char[pastures];
		
		final long startTime = System.currentTimeMillis();
		
		int startPast = paths[0][0];
		
		final long endTime = System.currentTimeMillis();
		
		if (paths.length % 2 == 0)
		{
			System.out.println(paths.length / 2);
		}
		else
		{
			System.out.println(paths.length / 2 + 1);
		}
		
		System.out.println("Total execution time: " + (endTime - startTime));
		f.close();
		System.exit(0);
	}
}
