package serenitylabs.tutorials.vetclinic.model;

public class ConfirmBookingStrategy implements CheckInStrategy {
	private final GuestList guestList;

	public ConfirmBookingStrategy(GuestList guestList) {
		this.guestList = guestList;
	}

	@Override
	public BookingResponse attemptToCheckIn(Pet pet) {
		guestList.add(pet);
		return BookingResponse.confirmedFor(pet);
	}
}
