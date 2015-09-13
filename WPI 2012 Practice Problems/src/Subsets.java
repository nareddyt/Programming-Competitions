// Teju Nareddy, 12/26/12

import java.util.*;

public class Subsets
{
	public static Scanner console = new Scanner(System.in);
	public static final char[] letters =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' }; // 10 only
	
	public static void main(String[] args)
	{
		int n = console.nextInt();
		int p = console.nextInt();
		int totalCombinations = getFactorial(n) / (getFactorial(p) * getFactorial(n - p));
		
		String[] combinations = new String[totalCombinations];
		
		for (int i = 0; i < combinations.length; i++)
		{
			
		}
	}
	
	public static int getFactorial(int num)
	{
		if (num > 1)
			return getFactorial(num - 1) * num;
		else
			return num;
	}
}
