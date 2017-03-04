package model;

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
            String result;
            switch(amountOfHours) {
                case 1 :
                case 13 : result = "een";
                break;
                case 2 :
                case 14 : result = "twee";
                break;
                case 3 :
                case 15 : result = "drie";
                break;
                case 4 :
                case 16 : result = "vier";
                break;
                case 5 :
                case 17 : result = "vijf";
                break;
                case 6 :
                case 18 : result = "zes";
                break;
                case 7 :
                case 19 : result = "zeven";
                break;
                case 8 :
                case 20 : result = "acht";
                break;
                case 9 :
                case 21 : result = "negen";
                break;
                case 10 :
                case 22 : result = "tien";
                break;
                case 11 :
                case 23 : result = "elf" ;
                break;
                case 0 :
                case 12 : result = "twaalf";
                break;
                default : result = "ongeldige invoer";
                break;
            }

            return result;
        }
    }
}
