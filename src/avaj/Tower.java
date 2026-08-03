package avaj;

import java.util.List;
import java.util.ArrayList;

public class Tower {
	Tower() {
		observers = new ArrayList<Flyable>();
	}

	private List<Flyable> observers;

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) {
		System.out.println("Tower says: " + p_flyable.toString() + " unregistered from the weather tower.");
		observers.remove(p_flyable);

	}

	// fail fast iterator will throw an exception if any modification has been made
	// to the content of the array, with the use of under the hood of ModCount
	// flag(that count every modification of the object).
	// the exception that will be thrown is the ConcurrentModificationException,
	// which is a runtime exception.
	// the solution : create a manual shallow copy of the list and iterate over it.
	protected void conditionChanged() {

		for (Flyable list_fly : new ArrayList<Flyable>(observers)) {
			list_fly.updateConditions();// TODO: check if this can throw the ConcurrentModificationException and why?
		}
	}
}
