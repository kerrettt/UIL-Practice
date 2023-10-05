import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import java.awt.Point;

			//change the class name
public class Chemicals
{
	char[][] mat;
	int countP;
	int countI;
	int row;
	int col;
	Point i;
	Point p;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("chemicals.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			countP=Integer.MIN_VALUE;
			countI=Integer.MIN_VALUE;
			row=file.nextInt();
			col=file.nextInt();
			file.nextLine();
			mat= new char[row][col];
			for(int i=0; i<mat.length;i++)
			{
				mat[i]=file.nextLine().toCharArray();
			
			}
			for(int r=0; r<mat.length;r++)
			{
				for(int c=0; c<mat[r].length;c++)
				{
					if(mat[r][c]=='P')
					{
						int temp=solve(r,c, 'P');
						
						if(temp > countP)
						{
							countP=temp;
							 p=new Point(r,c);
						}
					}
					if(mat[r][c]=='I')
					{
						int temp=solve(r,c, 'I');
						
						if(temp > countI)
						{
							countI=temp;
							 i=new Point(r,c);
						}
					}
				}
			}
			if(countP>countI)
			{
				System.out.println("The biggest spill is Phosphorus at (" + (int)p.getX() + "," + (int)p.getY() + ")" );
			}
			else
			{
				System.out.println("The biggest spill is Iodine at (" + (int)i.getX() + "," + (int)i.getY() + ")" );
			}
			
		}
	}
	public int solve(int startx, int starty, char search)
	{
		if(startx>=0 && starty>=0 && startx<row && starty<col && mat[startx][starty]==search )
		{
			mat[startx][starty]='.';
			return 1 + solve(startx-1, starty, search) + solve(startx+1, starty, search) + solve(startx, starty-1, search) + solve(startx, starty+1, search);
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Chemicals().run();
	}	
	
}