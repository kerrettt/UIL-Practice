import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob5{
	public static void main(String[] args) throws Exception{
		new prob5().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in5.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			String start = file.next();
			String home = file.next();
			Map<String,TreeSet<String>> map = new TreeMap<String,TreeSet<String>>();
			int n = file.nextInt();
			for(int i = 0;i<n;i++)
			{
				String a = file.next();
				String b = file.next();
				if(!map.containsKey(a))
					map.put(a,new TreeSet<String>());
				if(!map.containsKey(b))
					map.put(b,new TreeSet<String>());
				map.get(a).add(b);
				map.get(b).add(a);
			}
			int q = file.nextInt();
			ArrayList<String> poss = new ArrayList<String>();
			poss.add(start);
			for(int i = 0;i<q;i++)
			{
				String x = file.next().replace("-",".");
				ArrayList<String> temp = new ArrayList<String>();
				for(String str:poss)
				{
					for(String s:map.get(str))
					{
						if(s.matches(x))
							temp.add(s);
					}
				}
				poss.clear();
				poss.addAll(temp);
			}
			System.out.println(poss.contains(home)?"Maybe home.":"Definitely lost.");
		}
	}
}