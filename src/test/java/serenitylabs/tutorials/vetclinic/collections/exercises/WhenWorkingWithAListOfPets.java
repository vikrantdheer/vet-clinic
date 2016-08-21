package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Pet;

public class WhenWorkingWithAListOfPets {

	@Test
	public void should_store_a_list_of_pets() {

		List<Pet> pets = new ArrayList<>();

		pets.add(Pet.cat().named("Felix"));
		pets.add(Pet.dog().named("Fido"));
		pets.add(Pet.parrot().named("Vikrant Parrot"));

		// TODO: Implement the equals and hashcode methods in the Pet class to
		// make this work
		assertThat(pets, hasItem(Pet.dog().named("Fido")));
	}

	@Test
	public void should_contain_a_list_of_pets_in_any_order() {

		List<Pet> pets = new ArrayList<>();

		pets.add(Pet.cat().named("Felix"));
		pets.add(Pet.dog().named("Fido"));
		pets.add(Pet.parrot().named("Vikrant Parrot"));

		assertThat(pets,
				containsInAnyOrder((Pet.cat().named("Felix")), (Pet.parrot().named("Vikrant Parrot")), (Pet.dog().named("Fido"))));
	}
}
