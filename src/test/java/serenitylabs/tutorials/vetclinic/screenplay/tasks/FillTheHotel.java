package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import serenitylabs.tutorials.vetclinic.model.Breed;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.ManageTheHotel;

public class FillTheHotel implements Task {

    private static int numberOfPets;
    private final Breed breed;

    public FillTheHotel(int numberOfPets, Breed breed) {
        this.numberOfPets = numberOfPets;
        this.breed = breed;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int petCOunt= 1; petCOunt <= numberOfPets; petCOunt++){
            Pet pet = new Pet("Pet #" + petCOunt, breed);
            actor.usingAbilityTo(ManageTheHotel.class).checkIn(pet);
        }
    }

    public static FillTheHotelBuilder with(int numberOfPets) {
        return new FillTheHotelBuilder(numberOfPets);
    }

    public static class FillTheHotelBuilder{
        private final int numberOfPets;

        public FillTheHotelBuilder(int numberOfPets) {
            this.numberOfPets = numberOfPets;
        }

        public Task cats() {
            return new FillTheHotel(numberOfPets, Breed.Cat);
        }
    }
}
