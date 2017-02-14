package model;

/**
 * Created by Bjorn on 14-2-2017.
 */
public class TimeConverter {
    private int amountOfHours, amountOfMinutes;

    public TimeConverter(int amountOfHours, int amountOfMinutes) {
        this.amountOfHours = amountOfHours;
        this.amountOfMinutes = amountOfMinutes;
    }

    public String convertTimeToString() {
        checkRoundToNextHour();

        String hoursInWords = convertHoursIntToWords(amountOfHours);
        String minutesInWords = convertMinutesIntToWords(amountOfMinutes);

        return formatString(hoursInWords, minutesInWords);
    }

    private String formatString(String hoursInWords, String minutesInWords) {
        String result = "De tijd is : ";
        if ( amountOfMinutes <= 7 || amountOfMinutes >= 53) {
            result += String.format("%s uur %s", hoursInWords, checkAMOrPM() );
        } else {
            result += String.format("%s %s %s", minutesInWords, hoursInWords, checkAMOrPM());
        }
        return result;
    }

    private void checkRoundToNextHour() {
        if (amountOfMinutes >= 23) {
            amountOfHours++;
        }
    }


    private String checkAMOrPM() {
        String result;

        if (amountOfHours >= 12) {
            result = "p.m.";
        } else result = "a.m.";

        return result;
    }

    private String convertHoursIntToWords(int amountOfHours) {
        String result;
        switch(amountOfHours) {
            case 0 : result = "twaalf"; break;
            case 1 : result = "een" ;   break;
            case 2 : result = "twee";	break;
            case 3 : result = "drie";	break;
            case 4 : result = "vier";	break;
            case 5 : result = "vijf";	break;
            case 6 : result = "zes" ;	break;
            case 7 : result = "zeven";	break;
            case 8 : result = "acht";	break;
            case 9 : result = "negen";	break;
            case 10 : result = "tien";	break;
            case 11 : result = "elf";	break;
            case 12 : result = "twaalf";break;
            case 13 : result = "een";   break;
            case 14 : result = "twee";  break;
            case 15 : result = "drie";  break;
            case 16 : result = "vier";  break;
            case 17 : result = "vijf";  break;
            case 18 : result = "zes";   break;
            case 19 : result = "zeven"; break;
            case 20 : result = "acht";  break;
            case 21 : result = "negen"; break;
            case 22 : result = "tien";  break;
            case 23 : result = "elf" ;  break;
            default : result = "ongeldige invoer"; break;
        }

        return result;
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
}
