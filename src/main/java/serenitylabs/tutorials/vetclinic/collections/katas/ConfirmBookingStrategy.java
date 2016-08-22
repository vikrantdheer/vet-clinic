/**
 * 
 */
package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.Collection;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * @author Vikrant
 *
 */
public class ConfirmBookingStrategy implements CheckInStrategy {

	private final Collection<Pet> pets;

	public ConfirmBookingStrategy(Collection<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public BookingResponse goingToCheckIn(Pet pet) {
		pets.add(pet);
		return BookingResponse.confirmedFor(pet);
	}

}
