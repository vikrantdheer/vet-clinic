package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Vikrant
 *
 */
public class WhenWeCreateANewDog {

	@Test
	public void a_new_dog_should_have_name() {
		Dog fido = Dog.called("Fido").ofBreed("Laborador").ofAge(5).andOfColor("Black");

		assertEquals("Fido", fido.getName());
		assertEquals("Laborador", fido.getBreed());
		assertEquals(5, fido.getAge());
		assertEquals("Black", fido.getColor().get(0));
	}

	@Test
	public void a_dog_should_be_print_in_a_readable_format() {

		Dog fido = Dog.called("Fido").ofBreed("Laborador").ofAge(6).andOfColor("Brown");
		assertThat(fido.toString(), is(equalTo("Fido the Brown Laborador")));
		assertThat(fido.toString(), startsWith("Fido"));
	}

	@Test
	public void a_dog_can_have_several_colors() {
		Dog fido = Dog.called("Fido").ofBreed("Laborador").ofAge(6).andOfColor("Brown", "White");
		assertThat(fido.getColor(), contains("Brown", "White"));
	}
}
