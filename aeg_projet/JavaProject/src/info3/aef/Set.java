/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.aef;

import java.util.ArrayList;
import java.util.Iterator;

public class Set<E> implements Iterable<E> {

	// FIELDS

	ArrayList<E> elements;

	// CONSTRUCTOR

	public Set() {
		elements = new ArrayList<E>();
	}

	// CLONE

	public Set<E> clone() {
		Set<E> set = new Set<E>();
		set.elements = (ArrayList<E>) this.elements.clone();
		return set;
	}

	// BUILDER

	public boolean add(E elt) {
		if (!elements.contains(elt)) {
			elements.add(elt);
			return true;
		} else
			return false;
	}

	// GETTER
	
	public E get(int i) {
		return elements.get(i);
	}

	// PREDICATE

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public boolean contains(E elt) {
		return elements.contains(elt);
	}

	// ITERATOR

	public Iterator<E> iterator() {
		return elements.iterator();
	}

	// PRINTER

	public String toString() {
		String string = new String();
		string += "{";
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E elt = iterator.next();
			string += elt.toString();
			if (iterator.hasNext())
				string += ",";
		}
		string += "}";
		return string;
	}

}
