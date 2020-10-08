package polimorfism;

import java.lang.Comparable;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class InsertionList<T extends Comparable<T>> {

	private List<T> internalList = new LinkedList<>();

	public void add(T elem) {
		internalList.add(elem);
		Collections.sort(internalList);
	}

	public void del(T elem) {
		internalList.remove(elem);
	}

	@Override
	public String toString() {
		return internalList.toString();	
	}

}
