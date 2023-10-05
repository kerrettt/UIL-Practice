import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob8{
	public static void main(String[] args) throws Exception{
		new prob8().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in8.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int capacity = file.nextInt();
			int dist = file.nextInt();
			int stores = file.nextInt();
			int total = file.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			int sum = 0;
			for(int n = 0;n<stores;n++)
			{
				file.next();
				list.add(file.nextInt());
				sum+=list.get(list.size()-1);
			}
			list.add(total-sum);
			Collections.sort(list);
			boolean flag = list.get(list.size()-1)>capacity*8*dist;
			System.out.println(flag?"AGONY":"BLISS");
		}
	}
}