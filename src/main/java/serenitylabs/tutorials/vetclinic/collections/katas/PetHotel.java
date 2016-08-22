package serenitylabs.tutorials.vetclinic.collections.katas;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

import serenitylabs.tutorials.vetclinic.Pet;

public class PetHotel {

	/**
	 * Number of Maximum pets allowd in Hotel
	 */
	private static final int MAXIMUM_PETS = 20;

	private final Collection<Pet> pets = new TreeSet<>(comparing(Pet::getName));
	private final Queue<Pet> waitingList = new LinkedList<>();

	/**
	 * 
	 * @return list of checked in pets
	 */
	public List<Pet> getPets() {
		return new ArrayList<>(pets);
	}

	/**
	 * Enum for Availability status
	 * 
	 * @author Vikrant
	 *
	 */
	private enum AvailabilityStatus {
		Available, Full
	};

	/**
	 * Map with availability status and strategy
	 */
	private static final HashMap<AvailabilityStatus, CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();
	{
		CHECK_IN_STRATEGY.put(AvailabilityStatus.Available, new ConfirmBookingStrategy(pets));
		CHECK_IN_STRATEGY.put(AvailabilityStatus.Full, new WaitingListStrategy(waitingList));
	}

	/**
	 * 
	 * @return availability status
	 */
	private AvailabilityStatus currentAvailability() {
		return (pets.size() >= MAXIMUM_PETS) ? AvailabilityStatus.Full : AvailabilityStatus.Available;
	}

	/**
	 * 
	 * @param pet
	 *            for checking in
	 * @return booking response for particular pet
	 */
	public BookingResponse checkIn(Pet pet) {
		CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(currentAvailability());
		return checkInStrategy.goingToCheckIn(pet);
	}

	/**
	 * 
	 * @return waiting list of pets
	 */
	public Collection<Pet> checkWaitingList() {
		return new ArrayList<>(waitingList);
	}

	/**
	 * 
	 * @param pet
	 *            for checking out
	 */
	public void checkOut(Pet pet) {
		pets.remove(pet);

		if (!waitingList.isEmpty()) {
			checkIn(waitingList.poll());
		}
	}

}
