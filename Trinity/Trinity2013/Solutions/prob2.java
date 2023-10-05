import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob2{
	public static void main(String[] args) throws Exception{
		new prob2().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in2.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int n = file.nextInt();
			int time = file.nextInt();
			double sum = 0.0;
			for(int i = 0;i<n;i++)
			{
				boolean cop = file.next().startsWith("C");
				double dist = file.nextDouble();
				file.next();
				int lim = Math.min(120,file.nextInt());
				if(!cop)
					lim = 120;
				sum+=dist/lim;
			}
			if(sum*60>time)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}
}