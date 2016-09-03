package serenitylabs.tutorials.vetclinic.model;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by vdheer on 9/3/2016.
 */
public class ManageTheHotel implements Ability {
    private final PetHotel petHotel;

    public ManageTheHotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public void checkIn(Pet pet) {
        petHotel.checkIn(pet);
    }

    public List<Pet> getPets() {
        return petHotel.getPets();
    }


    public List<Pet> getWaitingList() {
        return petHotel.getWaitingList();
    }
}
