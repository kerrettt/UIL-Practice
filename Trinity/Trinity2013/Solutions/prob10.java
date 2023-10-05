import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob10{
	public static void main(String[] args) throws Exception{
		new prob10().run();
	}
	HashMap<String, Integer> map;
	int count;
	int get(String s){
		if( map.get(s) == null)
			map.put(s, count++);
		return map.get(s);
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in10.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			map = new HashMap<String, Integer>();
			count = 0;
			int INF = 1000000000;
			int n = file.nextInt(), N = n+1, tot = 0; file.nextLine();
			int[][] m = new int[N][N];
			for(int i = 0; i<n; i++){
				String[] s = file.nextLine().split(" ");
				int a= get(s[0]);
				tot += m[a][n] = parseInt(s[1]);
				for(int j = 2; j<s.length; j+=2)
					m[a][get(s[j])] = Integer.parseInt(s[j+1]);
			}
			int flo = 0;
			while(true){
				int[] prev = new int[N];
				Arrays.fill(prev, -1);
				boolean[] vis = new boolean[N];
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(0); vis[0] = true;
				while(!q.isEmpty()){
					int x = q.remove();
					for(int i = 0; i<N; i++)
						if( !vis[i] && m[x][i] > 0){
							vis[i] = true; prev[i] = x;
							q.add(i);
						}
				}
				if( prev[n] == -1)break;
				int min = INF;
				int cur = n;
				while(cur != 0){
					min = Math.min(min, m[prev[cur]][cur]);
					cur = prev[cur];
				}
				cur = n;
				while(cur != 0){
					m[cur][prev[cur]] += min;
					m[prev[cur]][cur] -= min;
					cur = prev[cur];
				}
				flo += min;
			}
			System.out.println (tot==flo?"SUCCESSFUL":"TOO HEAVY");
		}
	}
}