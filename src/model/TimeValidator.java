package model;

/**
 * Created by Bjorn on 14-2-2017.
 */
public class TimeValidator {
    private int amountOfHours, amountOfMinutes;

    public TimeValidator(int amountOfHours, int amountOfMinutes) {
        this.amountOfHours = amountOfHours;
        this.amountOfMinutes = amountOfMinutes;
    }

    public boolean runValidations() {
        return validateHours() && validateMinutes();
    }

    private boolean validateHours() {
        return amountOfHours >= 0 && amountOfHours <= 23;
    }

    private boolean validateMinutes() {
        return amountOfMinutes >= 0 && amountOfMinutes <= 59;
    }
}
