package serenitylabs.tutorials.vetclinic.webdriver;

/**
 * Created by vdheer on 9/10/2016.
 */
public enum ClassType {
    Economy(0), PremiumEconomy(1), Business(2), First(3);

    private final int indexOfType;

    ClassType(int indexOfType) {
        this.indexOfType = indexOfType;
    }

    public int getIndex() {
        return indexOfType;
    }
}
