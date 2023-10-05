import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob1{
	class prod implements Comparable<prod> {
		String name;
		double cost, rev;
		int ord;
		prod( String n, double c, int o ) {
			name = n;
			cost = c;
			ord = o;
			rev = cost * ord;
		}
		public int compareTo( prod a ) {
			return rev < a.rev? 1: rev == a.rev? 0: -1;
		}
		public String toString() {
			return String.format("%s %.2f %d Revenue: %.2f",name,cost,ord,rev);
		}
	}
	public static void main(String[] args) throws Exception{
		new prob1().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in1.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int k = file.nextInt();file.nextLine();
			ArrayList<prod> receipt = new ArrayList<prod>();
			for ( int i =0 ; i < k; i++ ) {
				String n= file.next();
				double cost = file.nextDouble();
				int ord = file.nextInt();
				file.nextLine();
				receipt.add( new prod(n, cost, ord) );
			}
			Collections.sort( receipt );
			double total = 0;
			for ( prod a: receipt ) {
				System.out.println( a);
				total += a.rev;
			}
			System.out.printf("Total Revenue: %.2f\n", total );
		}
	}
}