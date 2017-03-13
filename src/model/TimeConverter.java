package model;

import java.util.HashMap;

/**
 * Author: Bjorn, created on 14-2-2017.
 */
public class TimeConverter {
    private int amountOfHours;
    private int amountOfMinutes;

    public TimeConverter(int amountOfHours, int amountOfMinutes) {
        this.amountOfHours = amountOfHours;
        this.amountOfMinutes = amountOfMinutes;
    }

    public String convertTimeToString() {
        checkRoundToNextHour();

        String hoursInWords = convertHoursIntToWords(amountOfHours);
        String minutesInWords = convertMinutesIntToWords(amountOfMinutes);

        return formatString(new TimeText(hoursInWords, minutesInWords));
    }

    // Extract Parameter Object
    private String formatString(TimeText timeText) {
        String result = "De tijd is : ";
        if ( amountOfMinutes <= 7 || amountOfMinutes >= 53 ) {
            result += String.format("%s uur %s", timeText.getHoursInWords(), checkAMOrPM() );
        } else {
            result += String.format("%s %s %s", timeText.getMinutesInWords(), timeText.getHoursInWords(), checkAMOrPM());
        }
        return result;
    }

    private void checkRoundToNextHour() {
        if (amountOfMinutes >= 23) {
            amountOfHours++;
        }
    }

    // Extract Method (Eerste commit: MyFrame.java, regel: 160-168)
    private String checkAMOrPM() {
        String result;

        if (amountOfHours >= 12) {
            result = "p.m.";
        } else result = "a.m.";

        return result;
    }

    private String convertHoursIntToWords(int amountOfHours) {
        // Extract Method Object
        return new HourConverter(amountOfHours).invoke();
    }

    private String convertMinutesIntToWords(int amountOfMinutes) {
        String result = "";

        if (amountOfMinutes >= 8 && amountOfMinutes <= 22) {
            result = "kwart over";
        }
        if (amountOfMinutes >=23 && amountOfMinutes <= 37) {
            result = "half";
        }
        if (amountOfMinutes >= 38 && amountOfMinutes <= 52) {
            result = "kwart voor";
        }

        return result;
    }

    private class HourConverter {
        private int amountOfHours;

        HourConverter(int amountOfHours) {
            this.amountOfHours = amountOfHours;
        }

        String invoke() {
            HashMap<Integer, String> numberToStringMap = new HashMap<Integer, String>();

            numberToStringMap.put(1, "een");
            numberToStringMap.put(2, "twee");
            numberToStringMap.put(3, "drie");
            numberToStringMap.put(4, "vier");
            numberToStringMap.put(5, "vijf");
            numberToStringMap.put(6, "zes");
            numberToStringMap.put(7, "zeven");
            numberToStringMap.put(8, "acht");
            numberToStringMap.put(9, "negen");
            numberToStringMap.put(10, "tien");
            numberToStringMap.put(11, "elf");
            numberToStringMap.put(12, "twaalf");
            numberToStringMap.put(13, "een");
            numberToStringMap.put(14, "twee");
            numberToStringMap.put(15, "drie");
            numberToStringMap.put(16, "vier");
            numberToStringMap.put(17, "vijf");
            numberToStringMap.put(18, "zes");
            numberToStringMap.put(19, "zeven");
            numberToStringMap.put(20, "acht");
            numberToStringMap.put(21, "negen");
            numberToStringMap.put(22, "tien");
            numberToStringMap.put(23, "elf");
            numberToStringMap.put(24, "twaalf");
            try {
                return numberToStringMap.get(amountOfHours);
            } catch(Exception e) {
                return "ongeldige invoer";
            }
        }
    }
}
