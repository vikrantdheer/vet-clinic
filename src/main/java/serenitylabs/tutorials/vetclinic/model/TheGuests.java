package serenitylabs.tutorials.vetclinic.model;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

/**
 * Created by vdheer on 9/3/2016.
 */
public class TheGuests implements Question<List<Pet>>{
    private final PetHotel petHotel;

    public TheGuests(PetHotel petHotel) {

        this.petHotel = petHotel;
    }

    public static Question<List<Pet>> registeredInTheHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getPets();
    }

    /*public static Question<List<Pet>> onTheWaitingList() {
        return new TheGuests();
    }*/

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheGuests(petHotel);
    }

    public static Question<List<Pet>> onTheWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getWaitingList();
    }
}
