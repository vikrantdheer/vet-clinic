/**
 * 
 */
package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.concurrent.atomic.AtomicInteger;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * @author Vikrant
 *
 */
public abstract class BookingResponse implements BookingAcknowledgement {

	private static final AtomicInteger bookingNumber = new AtomicInteger();
	private final int number;
	private final Pet pet;

	/**
	 * @param number
	 * @param pet
	 */
	public BookingResponse(int number, Pet pet) {
		this.number = number;
		this.pet = pet;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the pet
	 */
	public Pet getPet() {
		return pet;
	}


	public static BookingResponse confirmedFor(Pet pet) {
		return new BookingConfirmation(bookingNumber.incrementAndGet(),pet);
	}

	public static BookingResponse waitingListFor(Pet pet) {
		return new WaitingConfirmation(bookingNumber.incrementAndGet(),pet);
	}
	
	

}
