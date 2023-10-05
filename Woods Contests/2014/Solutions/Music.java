import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Music
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("music.dat"));
		//System.setOut(new PrintStream(new File("music.out")));
		//System.setOut(new PrintStream(new File("music2.out")));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int s = file.nextInt();
			int m = file.nextInt();
			boolean[][] b = new boolean[n][n];
			int[] v = new int[n];
			for(int i = 0;i<v.length;i++)
			{
				v[i] = file.nextInt();
				b[i][i] = true;
				b[i][(i+1)%n] = true;
				b[i][(214013*i+2531011)%n] = true;
			}
			int[][] dp = new int[m][n];
			for(int[] in:dp)
				Arrays.fill(in,-1);
			dp[0][s] = v[s];
			for(int i = 0;i<dp.length - 1;i++)
				for(int j = 0;j<dp[i].length;j++)
					if(dp[i][j]!=-1)
						for(int k = 0;k<n;k++)
							if(b[j][k])
								dp[i+1][k] = Math.max(dp[i+1][k],dp[i][j]+v[k]);
			int ans = -1;
			for(int i:dp[dp.length-1])
				ans = Math.max(ans,i);
			
			System.out.println(ans);
		}
	}
	
	public static void genCases()throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter(new File("music2j.in")));
		out.println(100);
		for(int i = 1;i<=100;i++)
		{
			int n = (int)(Math.random()*(i*10))+1;
			int start = (int)(Math.random()*n);
			int m = (int)(Math.random()*(i*20))+1;
			out.println(n+" "+start+" "+m);
			String s = "";
			for(int q = 0;q<n;q++)
				s+=(int)(Math.random()*30)+" ";
			out.println(s.trim());
		}
		out.close();
	}

	public static void main(String[] args) throws Exception
	{
		//genCases();
		new Music().run();
	}	
	
}