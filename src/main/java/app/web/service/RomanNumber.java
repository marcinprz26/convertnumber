package app.web.service;

import app.web.util.Converter;

import java.util.TreeMap;

public class RomanNumber implements Converter {

    private static final TreeMap<Integer, String> ROM = new TreeMap<>();

    static {
        ROM.put(new Integer(1000000), "_M");
        ROM.put(new Integer(900000), "_C_M");
        ROM.put(new Integer(500000), "_D");
        ROM.put(new Integer(400000), "_C_D");
        ROM.put(new Integer(100000), "_C");
        ROM.put(new Integer(90000), "_X_C");
        ROM.put(new Integer(50000), "_L");
        ROM.put(new Integer(40000), "_X_L");
        ROM.put(new Integer(10000), "_X");
        ROM.put(new Integer(9000), "M_X");
        ROM.put(new Integer(5000), "_V");
        ROM.put(new Integer(4000), "M_V");
        ROM.put(new Integer(1000), "M");
        ROM.put(new Integer(900), "CM");
        ROM.put(new Integer(500), "D");
        ROM.put(new Integer(400), "CD");
        ROM.put(new Integer(100), "C");
        ROM.put(new Integer(90), "XC");
        ROM.put(new Integer(50), "L");
        ROM.put(new Integer(40), "XL");
        ROM.put(new Integer(10), "X");
        ROM.put(new Integer(9), "IX");
        ROM.put(new Integer(5), "V");
        ROM.put(new Integer(4), "IV");
        ROM.put(new Integer(1), "I");
    }

    @Override
    public String convertFromDecimal(String number) {
        int numb = Integer.parseInt(number);
        int floor = ROM.floorKey(Integer.parseInt(number));
        if(numb == floor) {
            return ROM.get(numb);
        }

        return ROM.get(floor) + convertFromDecimal(new String().valueOf(numb - floor));
    }
}
