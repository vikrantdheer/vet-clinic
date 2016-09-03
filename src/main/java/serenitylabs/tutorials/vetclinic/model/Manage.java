package serenitylabs.tutorials.vetclinic.model;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by vdheer on 9/3/2016.
 */
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
