// Extract Parameter Object
package model;

public class TimeText {
    private final String hoursInWords;
    private final String minutesInWords;

    public TimeText(String hoursInWords, String minutesInWords) {
        this.hoursInWords = hoursInWords;
        this.minutesInWords = minutesInWords;
    }

    public String getHoursInWords() {
        return hoursInWords;
    }

    public String getMinutesInWords() {
        return minutesInWords;
    }
}
