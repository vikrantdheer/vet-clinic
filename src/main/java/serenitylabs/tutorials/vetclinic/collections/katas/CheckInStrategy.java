/**
 * 
 */
package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * @author Vikrant
 *
 */
public interface CheckInStrategy {

	BookingResponse goingToCheckIn(Pet pet);

}
