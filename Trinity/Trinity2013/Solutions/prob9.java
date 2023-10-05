import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob9{
	public static void main(String[] args) throws Exception{
		new prob9().run();
	}
	HashMap<String, Integer> map;
	int count;
	int get(String s){
		if( map.get(s) == null)
			map.put(s, count++);
		return map.get(s);
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in9.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			map = new HashMap<String, Integer>();
			count = 0;
			int INF = 1000000000;
			int n = file.nextInt(); file.nextLine();
			int[][] m = new int[n][n];
			for(int[] ar : m)
				Arrays.fill(ar, INF);
			for(int i = 0; i<n; i++){
				String[] s = file.nextLine().split(" ");
				int a= get(s[0]);
				for(int j = 1; j<s.length; j+=2)
					m[a][get(s[j])] = Integer.parseInt(s[j+1]);
			}
			int[] dist = new int[n];
			boolean[] use = new boolean[n];
			Arrays.fill(dist, INF);
			dist[0] = 0;
			int tot = 0;
			for(int i = 0; i<n; i++){
				int min = INF, minn = -1;
				for(int j = 0; j<n; j++)
					if( !use[j] && dist[j] < min)
						min = dist[minn=j];
				use[minn] = true;
				tot += min;
				for(int j = 0; j<n; j++)
					if( m[minn][j] < dist[j])
						dist[j] = m[minn][j];
			}
			System.out.println (tot);
		}
	}
}