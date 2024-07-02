package test11;

import java.util.Comparator;

public class Decending implements Comparator<Object>{
	
	public int compare(Object o1, Object o2) {
		return ((Integer)o2).intValue() - (((Integer) o1).intValue());
		}
}
