package app.web.service;

import app.web.util.Converter;

import java.math.BigInteger;
import java.util.HashMap;

public class HexadecimalNumber implements Converter {

    private static final BigInteger base = new BigInteger("16");
    private static final HashMap<BigInteger, String> HEX = new HashMap<>();

    static {
        HEX.put(new BigInteger("10"), "A");
        HEX.put(new BigInteger("11"), "B");
        HEX.put(new BigInteger("12"), "C");
        HEX.put(new BigInteger("13"), "D");
        HEX.put(new BigInteger("14"), "E");
        HEX.put(new BigInteger("15"), "F");
    }

    @Override
    public String convertFromDecimal(String number) {
        StringBuilder result = new StringBuilder();
        BigInteger mod;
        BigInteger counter = new BigInteger(number);

        do {
            mod = counter.mod(base);
            result.append(mod.compareTo(new BigInteger("9")) == 1 ?
                    getDec(mod) : mod.toString());
            counter = counter.divide(base);
        } while(counter.compareTo(BigInteger.ZERO) != 0);

        return result.reverse().toString();
    }

    private String getDec(BigInteger number) {
        return HEX.get(number);
    }

}
