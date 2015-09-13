import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: auto
 */

public class auto
{
	public static String[] words;
	public static String[] wordsSorted;
	public static String[] toAuto;
	public static int[] index;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("auto.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		words = new String[Integer.parseInt(st.nextToken())];
		toAuto = new String[Integer.parseInt(st.nextToken())];
		index = new int[toAuto.length];
		
		for (int i = 0; i < words.length; i++)
		{
			words[i] = f.readLine();
		}
		for (int i = 0; i < toAuto.length; i++)
		{
			st = new StringTokenizer(f.readLine());
			index[i] = Integer.parseInt(st.nextToken());
			toAuto[i] = st.nextToken();
			
		}
		wordsSorted = Arrays.copyOf(words, words.length);
		Arrays.sort(wordsSorted);
		// Initialized all arrays
		
		// Beginning of finding
		for (int i = 0; i < toAuto.length; i++)
		{
			String wordFound = "";
			int count = 0;
			String toAutoWord = toAuto[i];
			int ind = index[i];
			boolean found = false;
			boolean alreadyFound = false;
			for (int a = 0; a < wordsSorted.length; a++)
			{
				if (isCompleteWord(wordsSorted[a], toAutoWord))
				{
					count++;
					alreadyFound = true;
				}
				else if (alreadyFound)
				{
					break;
				}
				if (count == ind)
				{
					found = true;
					wordFound = wordsSorted[a];
					break;
				}
			}
			if (found)
			{
				for (int b = 0; b < words.length; b++)
				{
					if (wordFound.equals(words[b]))
					{
						out.println(++b);
						break;
					}
				}
			}
			else
			{
				out.println("-1");
			}
		}
		
		f.close();
		out.close();
		System.exit(0);
	}
	
	public static boolean isCompleteWord(String word, String part)
	{
		if (word.contains(part))
		{
			for (int i = 0; i < part.length(); i++)
			{
				if (word.charAt(i) != part.charAt(i))
					return false;
			}
			return true;
		}
		return false;
	}
}
