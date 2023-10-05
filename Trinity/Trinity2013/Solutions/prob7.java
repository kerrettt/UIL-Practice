import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class prob7{
	public static void main(String[] args) throws Exception{
		new prob7().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("in7.txt"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			Map<String,Integer> catalog = new TreeMap<String,Integer>();
			int numCat = file.nextInt();
			for ( int i = 0; i < numCat; i++ ) {
				String temp = file.next();
				String temp2 = file.next();
				while ( !temp2.matches("[$][0-9]+") ) {
					temp += " " + temp2;
					temp2 = file.next();
				}
				catalog.put(temp,Integer.parseInt(temp2.replace("$","")));
				file.nextLine();
			}
			int ordersPerMonth = file.nextInt();
			double monthlyIncome = 0;
			for ( int i = 0; i < ordersPerMonth; i++ ) {
				String temp = file.next();
				String temp2 = file.next();
				while ( !temp2.matches("[0-9]+") ) {
					temp += " " + temp2;
					temp2 = file.next();
				}
				int numOrdered = Integer.parseInt( temp2 );
				int costPerItem = Integer.parseInt( file.next().replace("$","") ) - catalog.get( temp );
				int totalProfit = numOrdered * costPerItem;
				monthlyIncome += totalProfit;
				file.nextLine();
			}
			double monthlyExpenses = Integer.parseInt( file.nextLine().replace("$","") );
			double vacationCost = Integer.parseInt( file.nextLine().replace("$","") );
			if ( (monthlyIncome - monthlyExpenses) <= 0 || vacationCost / (monthlyIncome - monthlyExpenses) > 12 ) {
				System.out.println("R.I.P");
			}
			else {
				System.out.println( (int)Math.ceil( vacationCost / (monthlyIncome - monthlyExpenses) ));
			}
		}
	}
}