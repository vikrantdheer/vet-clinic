package serenitylabs.tutorials.vetclinic.collections.katas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Pet;

public class WhenBookingPetsIntoAPetHotel {

	@Test
	public void the_hotel_should_initially_have_no_pets_booked() {
		// Given
		PetHotel petHotel = new PetHotel();

		// Then
		assertThat(petHotel.getPets(), hasSize(0));
	}

	@Test
	public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
		// Given
		PetHotel petHotel = new PetHotel();
		Pet tommy = Pet.dog().named("Tommy");

		// When
		petHotel.checkIn(tommy);

		// Then
		assertThat(petHotel.getPets(), hasItem(tommy));
	}

	@Test
	public void should_be_able_to_check_in_several_pets() throws Exception {
		// Given
		PetHotel petHotel = new PetHotel();
		Pet tommy = Pet.dog().named("Tommy");
		Pet caty = Pet.cat().named("Caty");

		// When
		petHotel.checkIn(tommy);
		petHotel.checkIn(caty);

		// Then
		assertThat(petHotel.getPets(), hasItems(tommy, caty));
	}

	@Test
	public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

		// Given
		PetHotel petHotel = new PetHotel();
		Pet tommy = Pet.dog().named("Tommy");
		Pet caty = Pet.cat().named("Caty");

		// When
		petHotel.checkIn(tommy);
		petHotel.checkIn(caty);
		petHotel.checkIn(tommy);

		// Then
		assertThat(petHotel.getPets(), containsInAnyOrder(tommy, caty));
	}

	@Test
	public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
		// Given
		PetHotel petHotel = new PetHotel();
		Pet c = Pet.dog().named("C");
		Pet b = Pet.cat().named("B");
		Pet a = Pet.fish().named("A");

		// When
		petHotel.checkIn(b);
		petHotel.checkIn(c);
		petHotel.checkIn(a);

		// Then
		assertThat(petHotel.getPets(), contains(a, b, c));
	}

	@Test
	public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

		PetHotel petHotel = new PetHotel();
		Pet tommy = Pet.dog().named("Tommy");

		BookingResponse bookingResponse = petHotel.checkIn(tommy);

		assertThat(bookingResponse.isConfirmed(), equalTo(true));
		assertThat(petHotel.getPets(), hasItem(tommy));

	}

	@Test
	public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

		PetHotel petHotel = APetHotel.with(20).checkedIn();

		Pet kharghosh = Pet.rabbit().named("Kharghosh");

		petHotel.checkIn(kharghosh);

		assertThat(petHotel.getPets(), not(hasItem(kharghosh)));
	}

	@Test
	public void should_notify_owner_that_the_hotel_is_full() throws Exception {

		PetHotel petHotel = APetHotel.with(20).checkedIn();

		Pet kharghosh = Pet.rabbit().named("Kharghosh");

		BookingResponse bookingResponse = petHotel.checkIn(kharghosh);

		assertThat(bookingResponse.isConfirmed(), equalTo(false));
		assertThat(bookingResponse.isOnWaitingList(), equalTo(true));

	}

	@Test
	public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

		PetHotel petHotel = APetHotel.with(20).checkedIn();

		Pet kharghosh = Pet.rabbit().named("Kharghosh");

		BookingResponse bookingResponse = petHotel.checkIn(kharghosh);

		assertThat(bookingResponse.isOnWaitingList(), equalTo(true));
		assertThat(petHotel.checkWaitingList(), hasItem(kharghosh));

	}

	@Test
	public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

		PetHotel petHotel = APetHotel.with(19).checkedIn();

		Pet tommy = Pet.dog().named("Tommy");
		Pet caty = Pet.cat().named("Caty");

		petHotel.checkIn(tommy);
		petHotel.checkIn(caty);

		petHotel.checkOut(tommy);

		assertThat(petHotel.getPets(), hasItem(caty));

	}

	@Test
	public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
		PetHotel petHotel = APetHotel.with(19).checkedIn();

		Pet tommy = Pet.dog().named("Tommy");
		Pet caty = Pet.cat().named("Caty");
		Pet kharghosh = Pet.rabbit().named("Kharghosh");

		petHotel.checkIn(kharghosh);
		petHotel.checkIn(caty);
		petHotel.checkIn(tommy);

		petHotel.checkOut(kharghosh);

		assertThat(petHotel.getPets(), hasItem(caty));
		assertThat(petHotel.getPets(), not(hasItem(tommy)));
	}

}
