package serenitylabs.tutorials.vetclinic.enumerations.katas;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import serenitylabs.tutorials.vetclinic.collections.katas.colours.Colour;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
	@Test
	public void should_know_about_all_the_main_colours() {

		List<String> colours = newArrayList(Colour.values()).stream().map(Colour::toString)
				.collect(Collectors.toList());
		assertThat(colours, contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White"));
	}

	@Test
	public void should_identify_primary_colours() {

		List<Colour> primaryColours = ImmutableList.of(Colour.Red, Colour.Yellow, Colour.Blue);

		primaryColours.forEach(color -> assertThat(color.isPrimary(), is(true)));
	}

	@Test
	public void should_identify_non_primary_colours() {

		List<Colour> primaryColours = ImmutableList.of(Colour.Orange, Colour.Green, Colour.Violet);

		primaryColours.forEach(color -> assertThat(color.isPrimary(), is(false)));
	}

	@Test
	public void black_and_white_are_not_considered_primary() {
		assertThat(Colour.Black.isPrimary(), equalTo(false));
		assertThat(Colour.White.isPrimary(), equalTo(false));
	}

	@Test
	public void red_is_the_opposite_of_green() {
		assertThat(Colour.Red.getOppositeColor(), is(Colour.Green));
	}

	@Test
	public void blue_is_the_opposite_of_orange() {
		assertThat(Colour.Blue.getOppositeColor(), is(Colour.Orange));
	}

	@Test
	public void yellow_is_the_opposite_of_violet() {
		assertThat(Colour.Yellow.getOppositeColor(), is(Colour.Violet));
	}

	@Test
	public void black_is_the_opposite_of_white() {
		assertThat(Colour.Black.getOppositeColor(), is(Colour.White));
	}

	@Test
	public void opposite_colours_are_symmetric() {
		Arrays.asList(Colour.values()).stream().forEach(colour -> {
			assertThat(colour.getOppositeColor().getOppositeColor(), is(colour));
		});
	}

	/**
	 * This is an example of an alternative approach using JUnitParam
	 */
	@Parameters({ "Red, Green", "Blue, Orange", "Violet, Yellow", "Black, White" })
	@Test
	public void should_identify_opposite_colours(Colour colour, Colour expectedOpposite) throws Exception {

		assertThat(colour.getOppositeColor(), is(expectedOpposite));
	}

}