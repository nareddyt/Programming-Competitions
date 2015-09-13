import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class decorate
{
	public static char[] pastureSigns;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("decorate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
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
		
		if (paths.length % 2 == 0)
		{
			out.println(paths.length / 2);
		}
		else
		{
			out.println(paths.length / 2 + 1);
		}
		
		out.close();
		f.close();
		System.exit(0);
	}
}
