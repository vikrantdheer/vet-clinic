package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import serenitylabs.tutorials.vetclinic.Pet;

public class WhenWorkingWithAListOfPetNames {

	Pet pet;

	@Test
	public void should_add_Fido_to_the_list_of_pets() {
		List<String> names = Lists.newArrayList();

		names.add("Fido");

		assertThat(names, hasItems("Fido"));
	}

	@Test
	public void should_remove_Fido_from_the_list_of_pets() {
		List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");

		names.remove(1);

		assertThat(names, hasItems("Felix", "Spot"));
	}

	@Test
	public void should_remove_the_first_pet_from_the_list_of_pets() {
		List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");

		names.remove(0);

		assertThat(names, hasItems("Fido", "Spot"));
	}

	@Test
	public void should_make_a_list_of_cats_and_dogs() {
		List<String> cats = Lists.newArrayList("Felix", "Spot");
		List<String> dogs = Lists.newArrayList("Fido", "Rover");

		List<String> catsAndDogs = Lists.newArrayList(cats);
		catsAndDogs.addAll(dogs);

		assertThat(catsAndDogs, hasItems("Felix", "Spot", "Fido", "Rover"));
	}

	@Test
	public void should_put_the_dogs_among_the_cats() {
		List<String> cats = Lists.newArrayList("Felix", "Spot");
		List<String> dogs = Lists.newArrayList("Fido", "Rover");

		List<String> catsAndDogs = Lists.newArrayList(cats);
		catsAndDogs.addAll(1, dogs);

		assertThat(catsAndDogs, hasItems("Felix", "Fido", "Rover", "Spot"));
	}

	@Test
	public void should_organise_pets_in_alphabetical_order() {
		List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

		pets.sort(Comparator.naturalOrder());

		assertThat(pets, hasItems("Felix", "Fido", "Rover", "Spot"));
	}

	@Test
	public void should_organise_pets_in_reverse_alphabetical_order() {
		List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

		pets.sort(Comparator.reverseOrder());

		assertThat(pets, hasItems("Spot", "Rover", "Fido", "Felix"));
	}

	@Test
	public void should_organise_pets_by_name_length() {
		List<String> pets = Lists.newArrayList("Felix", "Alfred", "Spot");

		//We can also do by Comparator 
		// pets.sort(BY_LENGTH);
		pets.sort(Comparator.comparing(String::length));

		assertThat(pets, contains("Spot", "Felix", "Alfred"));
	}

}
