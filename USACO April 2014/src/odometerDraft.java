import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: odometer
 */

public class odometerDraft
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("odometer.txt")); // FIXME
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());
		int count = 0;
		
		final long startTime = System.currentTimeMillis();
		while (start <= end)
		{
			if (isInteresting(start))
			{
				System.out.println(start);
				count++;
			}
			start++;
		}
		final long endTime = System.currentTimeMillis();
		
		System.out.println("\n" + count);
		System.out.println("Total execution time: " + (endTime - startTime));
		f.close();
		System.exit(0);
	}
	
	public static boolean isInteresting(long num)
	{
		int a1 = (int) (num % 10);
		int cA1 = 1;
		num /= 10;
		
		int a2 = -1;
		int cA2 = 0;
		
		while (num != 0)
		{
			int dig = (int) (num % 10);
			if (dig == a1)
			{
				cA1++;
			}
			else if (dig == a2)
			{
				cA2++;
			}
			else if (a2 == -1)
			{
				a2 = dig;
				cA2++;
			}
			else
				return false;
			
			if (cA1 > 1 && cA2 > 1)
				return false;
			num /= 10;
		}
		
		if (cA2 == 0)
			return false;
		
		return true;
	}
}
