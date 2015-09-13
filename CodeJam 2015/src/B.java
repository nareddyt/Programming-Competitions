import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Teju Nareddy
 * 4/10/15
 * CodeJam 2015: Problem B
 */

public class B
{
	public static int maxIndex = 0;
	
	public static int getMax(ArrayList<Integer> array)
	{
		int max = 0;
		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i) > max)
			{
				max = array.get(i);
				maxIndex = i;
			}
		}
		return max;
	}
	
	public static int getNumberOfNonZero(ArrayList<Integer> array)
	{
		int count = 0;
		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i) != 0)
			{
				count++;
			}
		}
		return count;
	}
	
	public static int getSecondMax(ArrayList<Integer> array)
	{
		int max = 0;
		for (int i = 0; i < array.size(); i++)
		{
			if (i == maxIndex)
			{
				i++;
				if (i == array.size())
				{
					break;
				}
			}
			if (array.get(i) > max)
			{
				max = array.get(i);
			}
		}
		return max;
	}
	
	public static int getSumOfElements(ArrayList<Integer> array)
	{
		int sum = 0;
		for (int i = 0; i < array.size(); i++)
		{
			sum += array.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("B-small-attempt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small-out.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int cases = Integer.parseInt(st.nextToken());
		
		for (int j = 1; j <= cases; j++)
		{
			st = new StringTokenizer(f.readLine());
			int diners = Integer.parseInt(st.nextToken());
			ArrayList<Integer> plates = new ArrayList<Integer>();
			
			st = new StringTokenizer(f.readLine());
			for (int i = 0; i < diners; i++)
			{
				plates.add(Integer.parseInt(st.nextToken()));
			}
			// Done getting input
			
			int sum = getSumOfElements(plates);
			int time = 0;
			
			while (sum > 0)
			{
				time++;
				int max = getMax(plates);
				
				int tempMax = max;
				if (tempMax == 1)
				{
					tempMax = 0;
				}
				else if (tempMax % 2 == 1)
				{
					tempMax++;
				}
				
				if (getNumberOfNonZero(plates) * 2 <= tempMax)
				{
					// Split the stack and give to another empty diner
					plates.set(maxIndex, max - max / 2);
					plates.add(max / 2);
				}
				else if (plates.size() > 1 && getSecondMax(plates) * 2 <= tempMax)
				{
					plates.set(maxIndex, max - max / 2);
					plates.add(max / 2);
				}
				else
				{
					// Reduce all by one
					plates = reduceAllByOne(plates);
				}
				sum = getSumOfElements(plates);
			}
			
			System.out.println("Case #" + j + ": " + time);
		}
		
		f.close();
		out.close();
	}
	
	public static ArrayList<Integer> reduceAllByOne(ArrayList<Integer> array)
	{
		for (int i = 0; i < array.size(); i++)
		{
			int value = array.get(i);
			if (value > 0)
			{
				array.set(i, value - 1);
			}
		}
		return array;
	}
}
