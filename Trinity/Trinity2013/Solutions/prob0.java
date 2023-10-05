import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob0{
	public static void main(String[] args) throws Exception{
		new prob0().run();
	}
	int n, m[][], INF = 1000000;
	HashMap<Integer, Integer> map;
	int r(int cur, int mask){
		if( mask == (1<<n)-1) return 0;
		if( cur == 0 && mask != 0) return INF;
		int hash = mask|cur<<n+2;
		Integer x = map.get(hash);
		if( x != null) return x;
		int min = INF;
		for(int i = 0; i<n; i++)
			if( cur != i && (mask & 1<<i) == 0)
				min = Math.min(min, r(i, mask|1<<i) + m[cur][i]);
		map.put(hash, min);
		return min;
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in0.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			m = new int[n = file.nextInt()][n];
			map = new HashMap<Integer, Integer>();
			for(int i = 0; i<n; i++){
				file.next();
				for(int j = i+1; j<n; j++)
					m[i][j] = m[j][i] = file.nextInt();
			}
			System.out.println (r(0,0) + " Miles");
		}
	}
}