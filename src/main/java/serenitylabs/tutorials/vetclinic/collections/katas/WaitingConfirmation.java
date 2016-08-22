/**
 * 
 */
package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * @author Vikrant
 *
 */
public class WaitingConfirmation extends BookingResponse {

	public WaitingConfirmation(int number, Pet pet) {
		super(number, pet);
	}

	@Override
	public boolean isConfirmed() {
		return false;
	}

	@Override
	public boolean isOnWaitingList() {
		return true;
	}

}
