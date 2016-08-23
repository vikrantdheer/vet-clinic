package serenitylabs.tutorials.vetclinic;

/**
 * 
 * @author Vikrant Dheer
 *
 */
public enum Breed {
	Cat("Felis catus"), Dog("Canis lupus familiaris"), Rabbit("Oryctolagus cuniculus"), Fish(
			"Carassius auratus"), Parrot("Psittaciformes");

	private String scientificName;

	Breed(String scientificName) {
		this.scientificName = scientificName;
	}

	public String scientificName() {
		return scientificName;
	}
}