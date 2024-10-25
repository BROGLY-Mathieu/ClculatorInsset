/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

@Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        if (nbr == null || nbr.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: Roman numeral cannot be null or empty.");
        }

        int result = 0;
        int prevValue = 0;

        for (int i = nbr.length() - 1; i >= 0; i--) {
            char romanChar = nbr.charAt(i);
            int value = romanCharToInteger(romanChar);

            if (value < prevValue) {
                result -= value; // If current value is less than previous, subtract it
            } else {
                result += value; // Otherwise, add it
            }

            prevValue = value;
        }

        return result;
    }

    private int romanCharToInteger(char romanChar) {
        switch (romanChar) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Invalid Roman numeral character: " + romanChar);
        }
    }


    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        return new String("XVXX");
    }

    @Override
    public Double divideTwoIntegers(Integer dividend, Integer divisor) throws IllegalArgumentException {
        if (divisor == null || divisor == 0) {
            throw new IllegalArgumentException("Le diviseur ne peut pas être nul ou égal à zéro.");
        }
        if (dividend == null) {
            throw new IllegalArgumentException("Le dividende ne peut pas être nul.");
        }
        double result = (double) dividend / divisor;
        return result;
    }

}
