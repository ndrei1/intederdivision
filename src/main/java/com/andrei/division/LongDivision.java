package com.andrei.division;

import java.util.ArrayList;
import java.util.List;

public class LongDivision {

    private int quantityOfNumber(int value) {
        return (int) Math.log10(value) + 1;
    }

    public Result calculation(int dividend, int divider) {
        int dividendFromPrinter = dividend;
        int constDivider = divider;
        if(dividend<0){
            dividend=dividend*-1;

        }
        int quantityOfNumberInDividend = quantityOfNumber(dividend);
        int[] bufferFromDividend = new int[quantityOfNumberInDividend];

        List<Integer> listWithDividend = new ArrayList<>();
        List<Integer> listWithMinuend = new ArrayList<>();
        List<Integer> listWithSubtract = new ArrayList<>();
        List<Integer> listWithIndex = new ArrayList<>();

        for (int i = 0; i < quantityOfNumberInDividend; i++) {
            bufferFromDividend[i] = dividend % 10;
            dividend = dividend / 10;
        }
        for (int i = quantityOfNumberInDividend; i > 0; i--) {
            listWithDividend.add(bufferFromDividend[i - 1]);
        }
        int minuend = 0;
        int newMinuend = 0;
        int subtrahend = 0;
        int index = 0;
        while (index < quantityOfNumberInDividend) {
            if (divider < 0) {
                divider = divider * -1;

            }
            while (minuend <= divider) {
                if (index == quantityOfNumberInDividend) {
                    break;
                }
                if (minuend == divider) {
                    break;
                }
                minuend = minuend * 10 + listWithDividend.get(index);

                index++;
            }

            subtrahend = (minuend / divider) * divider;
            listWithMinuend.add(minuend);
            newMinuend = minuend - subtrahend;
            listWithIndex.add(newMinuend);
            minuend = newMinuend;
            listWithSubtract.add(subtrahend);

        }

        int reminder = minuend;
        return new Result(constDivider, dividendFromPrinter, listWithMinuend, listWithSubtract, listWithDividend, reminder, listWithIndex);
    }
}
