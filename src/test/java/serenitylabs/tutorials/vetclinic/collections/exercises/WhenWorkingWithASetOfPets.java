package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.NavigableSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class WhenWorkingWithASetOfPets {

	@Test
	public void should_add_Fido_to_the_set_of_pets() {
		Set<String> names = Sets.newHashSet();

		names.add("Fido");

		assertThat(names, contains("Fido"));

	}

	@Test
	public void a_set_of_pets_should_not_contain_duplicates() {
		Set<String> names = Sets.newHashSet();

		names.add("Fido");
		names.add("Felix");
		names.add("Fido");

		assertThat(names, containsInAnyOrder("Fido", "Felix"));
	}

	@Test
	public void adding_several_pets() {
		Set<String> names = Sets.newHashSet("Fido", "Felix");

		names.addAll(Sets.newHashSet("Felix", "Spot"));

		assertThat(names, containsInAnyOrder("Fido", "Felix", "Spot"));
	}

	@Test
	public void the_set_should_check_pets_in_the_ascending_order_with_uniqueness() {

		NavigableSet<String> names = Sets.newTreeSet();

		names.add("Rover");
		names.add("Fido");
		names.add("Rover");
		names.add("Felix");
		names.add("Spot");
		names.add("Felix");

		assertThat(names, contains("Felix", "Fido", "Rover", "Spot"));
	}

	@Test
	public void the_set_should_check_pets_in_the_order_they_where_added_with_uniqueness() {

		Set<String> names = Sets.newLinkedHashSet();

		names.add("Rover");
		names.add("Fido");
		names.add("Rover");
		names.add("Felix");
		names.add("Spot");
		names.add("Rover");
		names.add("Felix");

		assertThat(names, contains("Rover", "Fido", "Felix", "Spot"));
	}
}
