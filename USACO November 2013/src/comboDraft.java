import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: combo
 */

public class comboDraft
{
	public static int[] farmer;
	public static int[] master;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("combo.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int count = 0;
		int max = Integer.parseInt(st.nextToken());
		farmer = new int[3];
		master = new int[3];
		
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < 3; i++)
		{
			farmer[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < 3; i++)
		{
			master[i] = Integer.parseInt(st.nextToken());
		}
		f.close();
		
		int[] numbers = new int[max + 2];
		for (int i = 0; i < max; i++)
		{
			numbers[i] = i + 1;
		}
		numbers[max] = max + 1;
		numbers[max + 1] = max + 2;
		
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(numbers));
		
		count = 250;
		if (getGreatestDiff() > 5)
		{
			// do nothing
		}
		else
		{
			int a = 5 - getDiff(0);
			int b = 5 - getDiff(1);
			int c = 5 - getDiff(2);
			
			count -= a * b * c;
			System.out.println(a + " " + b + " " + c);
		}
		
		// TODO
		System.out.println(count);
		System.exit(0);
	}
	
	public static int getSmallestDiff()
	{
		int a = getDiff(0);
		int b = getDiff(1);
		int c = getDiff(2);
		
		if (b < a)
		{
			a = b;
		}
		if (c < a)
			return c;
		return a;
	}
	
	public static int getGreatestDiff()
	{
		int a = getDiff(0);
		int b = getDiff(1);
		int c = getDiff(2);
		
		if (b > a)
		{
			a = b;
		}
		if (c > a)
			return c;
		return a;
	}
	
	public static int getDiff(int i)
	{
		return Math.abs(farmer[i] - master[i]);
	}
}
