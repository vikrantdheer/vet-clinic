package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Dog {

	private final String name;
	private final String breed;
	private final List<String> color;
	private final int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @return the color
	 */
	public List<String> getColor() {
		return new ArrayList(color);
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param name
	 * @param breed
	 * @param age
	 * @param color
	 */
	public Dog(String name, String breed, int age, List<String> color) {
		super();
		this.name = name;
		this.breed = breed;
		this.color = color;
		this.age = age;
	}

	public static DogBuilder called(String name) {
		return new DogBuilder(name);
	}

	public static class DogBuilder {

		private String name;
		private String breed;
		private int age;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the breed
		 */
		public String getBreed() {
			return breed;
		}

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		public DogBuilder(String name) {
			this.name = name;
		}

		public DogBuilder ofBreed(String breed) {
			this.breed = breed;
			return this;
		}

		public DogBuilder ofAge(int age) {
			this.age = age;
			return this;
		}

		public Dog andOfColor(String... color) {
			return new Dog(name, breed, age, ImmutableList.copyOf(color));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " the " + color.get(0) + " " + breed;
	}

}