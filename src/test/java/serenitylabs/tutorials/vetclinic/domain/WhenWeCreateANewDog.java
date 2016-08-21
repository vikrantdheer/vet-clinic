/**
 * 
 */
package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vikrant
 *
 */
public class WhenWeCreateANewDog {

	@Test
	public void a_new_dog_should_have_name() {
		Dog fido = Dog.called("Fido").ofBreed("Laborador").age(5).andOfColor("Black");

		Assert.assertEquals("Fido", fido.getName());

		Assert.assertEquals("Laborador", fido.getBreed());

		Assert.assertEquals(5, fido.getAge());

		Assert.assertEquals("Black", fido.getColor());

	}

}
