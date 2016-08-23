package serenitylabs.tutorials.vetclinic.collections.katas.colours;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @author Vikrant Dheer
 *
 */
public enum Colour {
	Red(true), Orange(false), Yellow(true), Green(false), Blue(true), Violet(false), Black(false), White(false);

	private final boolean isPrimary;

	Colour(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public Colour getOppositeColor() {
		return OPPOSITE_COLOR.get(this);
	}

	private static final Map<Colour, Colour> OPPOSITE_COLOR = Maps.newHashMap();

	static {
		OPPOSITE_COLOR.put(Red, Green);
		OPPOSITE_COLOR.put(Green, Red);
		OPPOSITE_COLOR.put(Blue, Orange);
		OPPOSITE_COLOR.put(Orange, Blue);
		OPPOSITE_COLOR.put(Violet, Yellow);
		OPPOSITE_COLOR.put(Yellow, Violet);
		OPPOSITE_COLOR.put(Black, White);
		OPPOSITE_COLOR.put(White, Black);

	}
}
