// Replace Constructor With Builder
package model;

public class TimeValidatorBuilder {
    private int amountOfHours;
    private int amountOfMinutes;

    public TimeValidatorBuilder setAmountOfHours(int amountOfHours) {
        this.amountOfHours = amountOfHours;
        return this;
    }

    public TimeValidatorBuilder setAmountOfMinutes(int amountOfMinutes) {
        this.amountOfMinutes = amountOfMinutes;
        return this;
    }

    public TimeValidator createTimeValidator() {
        return new TimeValidator(amountOfHours, amountOfMinutes);
    }
}