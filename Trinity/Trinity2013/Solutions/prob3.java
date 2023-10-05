import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob3{
	public static void main(String[] args) throws Exception{
		new prob3().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in3.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int S = file.nextInt(), T = file.nextInt(), N = file.nextInt();
			int[] vals = new int[N], space = new int[N], time = new int[N];
			int[][][] d = new int[S+1][T+1][N+1];
			for(int i = 0; i<N; i++){
				file.next();
				vals[i] = file.nextInt();
				space[i] = file.nextInt();
				time[i] = file.nextInt();
			}
			for(int s = 1; s<=S; s++)
				for(int t = 0; t<=T; t++)
					for(int i = 0; i<N; i++){
						d[s][t][i+1] = d[s][t][i];
						if( space[i] <= s && time[i]<=t)
							d[s][t][i+1] = Math.max(d[s][t][i+1], d[s-space[i]][t-time[i]][i] + vals[i]);
					}
			System.out.println (d[S][T][N]);
		}
	}
}