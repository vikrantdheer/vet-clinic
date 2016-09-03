package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.*;
import serenitylabs.tutorials.vetclinic.model.Manage;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.FillTheHotel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {


    PetHotel petHotel;
    @Before
    public void estabilishHotel() {

        GuestList guestList = new GuestList();
        WaitingList waitingList = new WaitingList();
        petHotel = new PetHotel("Pet Hotel California", guestList, waitingList);
    }


    @Test
    public void petra_checks_her_cat_in_when_the_hotel_is_full() {
        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");

        //PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        Actor harry = Actor.named("Harry the hotel manager");

        harry.can(Manage.the(petHotel));

        harry.wasAbleTo(FillTheHotel.with(20).cats());

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // WHEN
        // petra.attemptsTo(CheckOut.aPet(ginger).from(petHotel));

        // THEN
        /*petra.should(
                seeThat(TheRegisteredGuests.in(petHotel), not(hasItem(ginger))),
                seeThat(TheGuestsOnTheWaitingList.forHotel(petHotel), hasItem(ginger))
        );*/

        harry.should(seeThat(TheGuests.registeredInTheHotel(), not(hasItem(ginger))));

        //this is when you do with only questions
       // harry.should(seeThat(TheGuests.in(petHotel), hasItem(ginger)));

        // this is when you do with abilties
        harry.should(seeThat(TheGuests.onTheWaitingList(), hasItem(ginger)));

    }
}
