/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: mirrors
 */

import java.awt.Point;
import java.io.*;
import java.util.*;

public class P1_Mirrors_TESTONLY
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("mirrors.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirrorsOut.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int lines = Integer.parseInt(st.nextToken());
		Point barn = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		// Stores all fences in new arrayList along with the orientation
		ArrayList<Point> fPos = new ArrayList<Point>();
		ArrayList<String> fOrient = new ArrayList<String>();
		for (int i = 0; i < lines; i++)
		{
			st = new StringTokenizer(f.readLine());
			Point newPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			fPos.add(newPoint);
			fOrient.add(st.nextToken());
		}
		
		// Gets the maximum value of X and Y
		int xMax = (int) barn.getX();
		int yMax = (int) barn.getY();
		for (int i = 0; i < fPos.size(); i++)
		{
			if (fPos.get(i).getX() > xMax)
			{
				xMax = (int) fPos.get(i).getX();
			}
			if (fPos.get(i).getY() > yMax)
			{
				yMax = (int) fPos.get(i).getY();
			}
		}
		
		// Makes new sorted lists in order: y = n; x = 0 - n --> y = n - 1...x = (see before)
		ArrayList<Point> fPosSorted = new ArrayList<Point>();
		ArrayList<String> fOrientSorted = new ArrayList<String>();
		int x = 0;
		int y = yMax;
		while (y >= 0)
		{
			int index = fPos.indexOf(new Point(x, y));
			if (index != -1)
			{
				fPosSorted.add(fPos.get(index));
				fOrientSorted.add(fOrient.get(index));
			}
			
			x++;
			if (x > xMax)
			{
				x = 0;
				y--;
			}
		}
		
		// Test Printing it out --> Works Perfectly!
		int index = 0;
		for (y = yMax; y >= 0; y--)
		{
			for (x = 0; x <= xMax; x++)
			{
				if (x == 0 && y == 0)
				{
					System.out.print("H");
				}
				else if (x == (int) barn.getX() && y == (int) barn.getY())
				{
					System.out.print("B");
				}
				else if (index < fPos.size() && x == (int) fPosSorted.get(index).getX()
						&& y == (int) fPosSorted.get(index).getY())
				{
					System.out.print(fOrientSorted.get(index));
					index++;
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}
		
		// Now the Logic Starts...
		int changed = -1;
		int answer = -99;
		for (int i = 0; i <= fPos.size(); i++)
		{
			x = 0;
			y = 0;
			String direction = "right";
			index = 0;
			while (x >= 0 && x <= xMax && y >= 0 && y <= yMax)
			{
				if (x == (int) barn.getX() && y == (int) barn.getY())
				{
					answer = changed;
					break;
				}
				else
				{
					if (direction.equals("right"))
					{
						x++;
					}
					else if (direction.equals("up"))
					{
						y++;
					}
					else if (direction.equals("left"))
					{
						x--;
					}
					else if (direction.equals("down"))
					{
						y--;
					}
					else
						throw new IllegalArgumentException("Check direction");
					
					if (fPos.contains(new Point(x, y)))
					{
						index = fPos.indexOf(new Point(x, y));
						String orient = fOrient.get(index);
						if (orient.equals("/"))
						{
							if (direction.equals("right"))
							{
								direction = "up";
							}
							else if (direction.equals("up"))
							{
								direction = "right";
							}
							else if (direction.equals("left"))
							{
								direction = "down";
							}
							else if (direction.equals("down"))
							{
								direction = "left";
							}
							else
								throw new IllegalArgumentException("Check direction inside /");
						}
						else
						{
							if (direction.equals("right"))
							{
								direction = "down";
							}
							else if (direction.equals("up"))
							{
								direction = "left";
							}
							else if (direction.equals("left"))
							{
								direction = "up";
							}
							else if (direction.equals("down"))
							{
								direction = "right";
							}
							else
								throw new IllegalArgumentException("Check direction inside \\");
						}
					}
				}
			}// end of while loop
			if (answer == changed)
			{
				break;
			}
			changed++;
			if (fOrient.get(changed).equals("/"))
			{
				fOrient.set(changed, "\\");
			}
			else
			{
				fOrient.set(changed, "/");
			}
			
			if (changed == 0)
			{
				// do nothing
			}
			else
			// sets previous change back
			{
				if (fOrient.get(changed - 1).equals("/"))
				{
					fOrient.set(changed - 1, "\\");
				}
				else
				{
					fOrient.set(changed - 1, "/");
				}
			}
		}
		if (changed == answer)
		{
			System.out.println("\nIt Works at " + (++answer));
		}
		else
		{
			System.out.println("\n-1");
		}
	}
}
