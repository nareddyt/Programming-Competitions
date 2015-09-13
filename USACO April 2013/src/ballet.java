/*
 * ID: nareddyt
 * LANG: JAVA
 * TASK: ballet
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ballet
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("ballet.in"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		Point fr = new Point(1, 1);
		Point fl = new Point(0, 1);
		Point rr = new Point(1, 0);
		Point rl = new Point(0, 0);
		
		int maxX = 1;
		int minX = 0;
		int maxY = 1;
		int minY = 0;
		int direction = 90;
		
		int stop = Integer.parseInt(st.nextToken());
		for (int i = 0; i < stop; i++)
		{
			st = new StringTokenizer(f.readLine());
			String next = st.nextToken();
			String begin = next.substring(0, 2);
			String end = next.substring(2);
			
			if (begin.equals("FR"))
			{
				if (end.equals("F"))
				{
					fr.move(direction);
				}
				else if (end.equals("B"))
				{
					if (direction > 180)
					{
						fr.move(direction - 180);
					}
					else
					{
						fr.move(direction + 180);
					}
				}
				else if (end.equals("R"))
				{
					if (direction >= 90)
					{
						fr.move(direction - 90);
					}
					else
					{
						fr.move(270);
					}
				}
				else if (end.equals("L"))
				{
					if (direction < 270)
					{
						fr.move(direction + 90);
					}
					else
					{
						fr.move(0);
					}
				}
				else
				{
					direction -= 90;
					if (direction == -90)
					{
						direction = 270;
					}
					
					int dx;
					int dy;
					dx = fr.x - fl.x;
					dy = fr.x - fl.x;
					fl.x = fr.x - dy;
					fl.y = fr.y + dx;
					
					dx = fr.x - rl.x;
					dy = fr.x - rl.x;
					rl.x = fr.x - dy;
					rl.y = fr.y + dx;
					
					dx = fr.x - rr.x;
					dy = fr.x - rr.x;
					rr.x = fr.x - dy;
					rr.y = fr.y + dx;
				}
				
			}
			else if (begin.equals("FL"))
			{
				if (end.equals("F"))
				{
					fl.move(direction);
				}
				else if (end.equals("B"))
				{
					if (direction > 180)
					{
						fl.move(direction - 180);
					}
					else
					{
						fl.move(direction + 180);
					}
				}
				else if (end.equals("R"))
				{
					if (direction >= 90)
					{
						fl.move(direction - 90);
					}
					else
					{
						fl.move(270);
					}
				}
				else if (end.equals("L"))
				{
					if (direction < 270)
					{
						fl.move(direction + 90);
					}
					else
					{
						fl.move(0);
					}
				}
				else
				{
					direction -= 90;
					if (direction == -90)
					{
						direction = 270;
					}
					
					int dx;
					int dy;
					dx = fl.x - fr.x;
					dy = fl.x - fr.x;
					fr.x = fl.x - dy;
					fr.y = fl.y + dx;
					
					dx = fl.x - rl.x;
					dy = fl.x - rl.x;
					rl.x = fl.x - dy;
					rl.y = fl.y + dx;
					
					dx = fl.x - rr.x;
					dy = fl.x - rr.x;
					rr.x = fl.x - dy;
					rr.y = fl.y + dx;
				}
			}
			else if (begin.equals("rr"))
			{
				if (end.equals("F"))
				{
					rr.move(direction);
				}
				else if (end.equals("B"))
				{
					if (direction > 180)
					{
						rr.move(direction - 180);
					}
					else
					{
						rr.move(direction + 180);
					}
				}
				else if (end.equals("R"))
				{
					if (direction >= 90)
					{
						rr.move(direction - 90);
					}
					else
					{
						rr.move(270);
					}
				}
				else if (end.equals("L"))
				{
					if (direction < 270)
					{
						rr.move(direction + 90);
					}
					else
					{
						rr.move(0);
					}
				}
				else
				{
					direction -= 90;
					if (direction == -90)
					{
						direction = 270;
					}
					
					int dx;
					int dy;
					dx = rr.x - fl.x;
					dy = rr.x - fl.x;
					fl.x = rr.x - dy;
					fl.y = rr.y + dx;
					
					dx = rr.x - rl.x;
					dy = rr.x - rl.x;
					rl.x = rr.x - dy;
					rl.y = rr.y + dx;
					
					dx = rr.x - fr.x;
					dy = rr.x - fr.x;
					fr.x = rr.x - dy;
					fr.y = rr.y + dx;
				}
			}
			else
			{
				if (end.equals("F"))
				{
					rr.move(direction);
				}
				else if (end.equals("B"))
				{
					if (direction > 180)
					{
						rr.move(direction - 180);
					}
					else
					{
						rr.move(direction + 180);
					}
				}
				else if (end.equals("R"))
				{
					if (direction >= 90)
					{
						rr.move(direction - 90);
					}
					else
					{
						rr.move(270);
					}
				}
				else if (end.equals("L"))
				{
					if (direction < 270)
					{
						rr.move(direction + 90);
					}
					else
					{
						rr.move(0);
					}
				}
				else
				{
					direction -= 90;
					if (direction == -90)
					{
						direction = 270;
					}
					
					int dx;
					int dy;
					dx = rl.x - fl.x;
					dy = rl.x - fl.x;
					fl.x = rl.x - dy;
					fl.y = rl.y - dx;
					
					dx = rl.x - rr.x;
					dy = rl.x - rr.x;
					rr.x = rl.x - dy;
					rr.y = rl.y - dx;
					
					dx = rl.x - fr.x;
					dy = rl.x - fr.x;
					fr.x = rl.x - dy;
					fr.y = rl.y - dx;
				}
			}
			
			if (fr.x > maxX)
			{
				maxX = fr.x;
			}
			if (fr.x < minX)
			{
				minX = fr.x;
			}
			if (fl.x > maxX)
			{
				maxX = fl.x;
			}
			if (fl.x < minX)
			{
				minX = fl.x;
			}
			if (rr.x > maxX)
			{
				maxX = rr.x;
			}
			if (rr.x < minX)
			{
				minX = rr.x;
			}
			if (rl.x > maxX)
			{
				maxX = rl.x;
			}
			if (rl.x < minX)
			{
				minX = rl.x;
			}
			if (fr.y > maxY)
			{
				maxY = fr.y;
			}
			if (fr.y < minY)
			{
				minY = fr.y;
			}
			if (fl.y > maxY)
			{
				maxY = fl.y;
			}
			if (fl.y < minY)
			{
				minY = fl.y;
			}
			if (rr.y > maxY)
			{
				maxY = rr.y;
			}
			if (rr.y < minY)
			{
				minY = rr.y;
			}
			if (rl.y > maxY)
			{
				maxY = rl.y;
			}
			if (rl.y < minY)
			{
				minY = rl.y;
			}
			
			if (fr.equals(fl) || fr.equals(rr) || fr.equals(rl) || fl.equals(rr) || fl.equals(rl) || rr.equals(rl))
			{
				System.out.println("-1");
				System.exit(0);
			}
		}
		
		f.close();
		
		System.out.println(((maxX - minX + 1) * (maxY - minY + 1)));
	}
}

class Point
{
	public int x;
	public int y;
	
	public Point(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	
	public void move(int direction) // Normal math angles
	{
		if (direction == 0)
		{
			x++;
		}
		else if (direction == 90)
		{
			y++;
		}
		else if (direction == 180)
		{
			x--;
		}
		else
		{
			y--;
		}
	}
	
	public boolean equals(Point p)
	{
		if (x == p.x && y == p.y)
			return true;
		return false;
	}
}
