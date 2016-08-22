/**
 * 
 */
package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.Collection;
import java.util.Queue;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * @author Vikrant
 *
 */
public class WaitingListStrategy implements CheckInStrategy {

	private final Collection<Pet> waitingListForPets;

	public WaitingListStrategy(Queue<Pet> waitingList) {
		this.waitingListForPets = waitingList;
	}

	@Override
	public BookingResponse goingToCheckIn(Pet pet) {
		waitingListForPets.add(pet);
		return BookingResponse.waitingListFor(pet);
	}

}
