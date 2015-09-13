import java.util.*;

// Teju Nareddy, 3/3/13

public class P10
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		ArrayList<String> origChars = new ArrayList<String>();
		ArrayList<String> newChars = new ArrayList<String>();
		
		String oldS = console.nextLine();
		String newS = console.nextLine();
		
		for (int i = 0; i < oldS.length(); i++)
		{
			String c = oldS.substring(i, i + 1);
			if (!c.equals(" "))
			{
				origChars.add(c);
			}
		}
		
		for (int i = 0; i < newS.length(); i++)
		{
			String c = newS.substring(i, i + 1);
			if (!c.equals(" "))
			{
				newChars.add(c);
			}
		}
		
		Collections.sort(origChars);
		Collections.sort(newChars);
		
		if (newChars.equals(origChars))
		{
			System.out.println("ANAGRAM");
		}
		else
		{
			System.out.println("NO ANAGRAM");
		}
		
		console.close();
		System.exit(0);
	}
}
