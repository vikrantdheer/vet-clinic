/**
 * 
 */
package serenitylabs.tutorials.vetclinic.screenplay;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

/**
 * @author Vikrant
 *
 */
@RunWith(SerenityRunner.class)
public class WhenCheckInToThePetHotel {

	@Test
	public void petra_books_her_pet_cat_into_the_hotel() {

		// GIVEN
		@SuppressWarnings("unused")
		Actor vikrant = Actor.named("Vikrant owner of pet");
		Pet goldy = Pet.fish().named("Goldy");
		PetHotel petHotel = PetHotel.called("Hotel Taj");

		// WHEN
		vikrant.attemptsTo(CheckIn.aPet(goldy).into(petHotel));

		// THEN
		assertThat(petHotel.getPets(), hasItem(goldy));

	}

	@Test
	public void vikrant_checks_his_fish_out_of_the_hotel() {

		// GIVEN
		Actor vikrant = Actor.named("Vikrant the pet owner");
		Pet goldy = Pet.fish().named("Goldy");
		PetHotel petHotel = PetHotel.called("Hotel Taj");

		// WHEN
		
		vikrant.wasAbleTo(CheckOut.aPet(goldy).from(petHotel));

		// THEN
		assertThat(petHotel.getPets(), not(hasItem(goldy)));
	}

}
