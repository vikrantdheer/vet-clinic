package serenitylabs.tutorials.vetclinic.webdriver;

/**
 * Created by vdheer on 9/10/2016.
 */
public enum Services {
    Flights("F"),Hotels("H");

    private String serviceType;

    Services(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getValue() {
        return serviceType;
    }
}
