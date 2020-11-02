/**
 * Iterator Lab
 * @author Darren King
 *
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;
public class iteratorGame {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Random rand = new Random();
		for(int i = 0; i < 20; i++) {
			list.add(Integer.toString(rand.nextInt(89) + 10));
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		game(list);
	}

	public static void game(ArrayList<String> list){
		ListIterator<String> iterator = list.listIterator();
		String one = iterator.next();
		String two = iterator.next();
		while(iterator.hasNext()) {
			if(one.charAt(0) != two.charAt(0) && one.charAt(1) != two.charAt(1) && iterator.hasNext()) { // goes on to comapre next set of values
				one = two;
				two = iterator.next();
			}
			if(one.charAt(0) == two.charAt(0) || one.charAt(1) == two.charAt(1)) {
				iterator.remove();
				one = iterator.next();
				two = iterator.next();
				iterator.previous();
				iterator.previous();
				iterator.previous();
				iterator.remove();
				while(iterator.hasPrevious()) // After removing identical numbers, list goes back to start
					iterator.previous();
				while(iterator.hasNext())
					System.out.print(iterator.next() + " "); // Prints out all remaining values
				while(iterator.hasPrevious()) // After printing all values, list goes back to start to compare all values
					iterator.previous();
				System.out.println();
			}
		}
	}
}
