package app.web.service;

import app.web.util.NumberSystem;

public class Conversion {

    public String conversion(String number, String system) {
        String result = "";

        switch(system) {
            case NumberSystem.HEX:
                result = validateHex(number) ?
                        new HexadecimalNumber().convertFromDecimal(number) :
                        "Value should be equal or greater than 0";
                break;
            case NumberSystem.ROM:
                result = validateRom(number) ?
                        new RomanNumber().convertFromDecimal(number) :
                        "Value should be grater than 0 and less than 4000000";
                break;
        }

        return result;
    }

    private boolean validateHex(String number) {
        int numb = Integer.parseInt(number);
        if(numb < 0) {
            return false;
        }
        return true;
    }

    private boolean validateRom(String number) {
        int numb = Integer.parseInt(number);
        if(numb <= 0 || numb >= 4000000) {
            return false;
        }
        return true;
    }
}
