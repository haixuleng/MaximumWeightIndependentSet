package assignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/mwis.txt");
		ArrayList<Integer> data = lt.get();
		Dynamic d = new Dynamic(data);
		System.out.println("1: " + d.check(1));
		System.out.println("2: " + d.check(2));
		System.out.println("3: " + d.check(3));
		System.out.println("4: " + d.check(4));
		System.out.println("17: " + d.check(17));
		System.out.println("117: " + d.check(117));
		System.out.println("517: " + d.check(517));
		System.out.println("997: " + d.check(997));
	}
}
